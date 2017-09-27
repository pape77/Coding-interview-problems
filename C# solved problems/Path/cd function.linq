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
 		string[] dots = {".."};
		string[] bars = {"/"};
		
		if(newPath.Contains(".."))
		{
		
			var split = newPath.Split(dots, StringSplitOptions.RemoveEmptyEntries);
			var currentPathSplit = this.CurrentPath.Split(bars,StringSplitOptions.RemoveEmptyEntries);
			int i = currentPathSplit.Length -1;
			var endsDots = newPath.Split(dots, StringSplitOptions.None);
			var top = endsDots[endsDots.Length-1] == ""? split.Length+1 : split.Length;
			
			for(int j = 0; j < top; j++)
			{
				this.CurrentPath =	this.CurrentPath.Substring(0,this.CurrentPath.Length - currentPathSplit[i].Length-1);
				i--;
			}
			
			if(split.Length > 0 && split[split.Length-1].Length != 1) 
			{
				this.CurrentPath += split[split.Length-1];
			}
			
			if(this.CurrentPath.Length == 0)
			{
				this.CurrentPath = "/";
			}
		}
		else
		{ 
			this.CurrentPath += "/"+newPath;
		}
    }

    public static void Main(string[] args)
    {
        Path path = new Path("/albertengo/bASD/c/dalesandro");
        path.Cd("../asd");
        Console.WriteLine(path.CurrentPath);
    }
}