<Query Kind="Program">
  <Namespace>System</Namespace>
</Query>

public class Path
{
    public string CurrentPath { get; private set; }

    public Path(string path)
    {
        this.CurrentPath = path;
    }

	public void Cd(string newPath)
	{
		string[] bars = {"/"};
		string[] dots = {".."};
		var currentPathSplit = this.CurrentPath.Split(bars,StringSplitOptions.RemoveEmptyEntries);
		var i = currentPathSplit.Length-1;
		var newPathTemp = newPath;
		
		if(newPath.Contains(".."))
		{
			while(newPathTemp.Contains(".."))
			{     
				this.CurrentPath =	this.CurrentPath.Substring(0,this.CurrentPath.Length - currentPathSplit[i].Length-1);
				newPathTemp = newPathTemp.Length >= 3? newPathTemp.Substring(3,newPathTemp.Length-3): newPathTemp.Substring(2,newPathTemp.Length-2);
				i--;
		    }
			
			var containsChild = newPath.Split(dots,StringSplitOptions.RemoveEmptyEntries);

			if(containsChild.Length >= 1 && containsChild[containsChild.Length-1] != "/" )
			{
				this.CurrentPath += containsChild[containsChild.Length-1];
			}
				  
			if(this.CurrentPath.Length == 0)
			{
				this.CurrentPath = "/";
			}
			}else
			{
				this.CurrentPath = this.CurrentPath+"/"+newPath;
			}
	    }


    public static void Main(string[] args)
    {
        Path path = new Path("/a/b/c/d");
        path.Cd("../../amarillo");
        Console.WriteLine(path.CurrentPath);
    }
}