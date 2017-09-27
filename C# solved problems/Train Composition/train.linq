<Query Kind="Program">
  <Namespace>System</Namespace>
  <Namespace>System.Collections.Generic</Namespace>
</Query>

public class TrainComposition
{
    public LinkedList<int> wagons = new LinkedList<int>();
	
    public void AttachWagonFromLeft(int wagonId)
    {
        wagons.AddFirst(wagonId);
    }

    public void AttachWagonFromRight(int wagonId)
    {
        wagons.AddLast(wagonId);
    }

    public int DetachWagonFromLeft()
    {
		if(wagons.Count > 0)
		{
			var res = wagons.First.Value;
			wagons.RemoveFirst();
			return res;
		}
		else
		{
			return -1;
		}
    }

    public int DetachWagonFromRight()
    {
      	if(wagons.Count > 0)
		{
			var res = wagons.Last.Value;
			wagons.RemoveLast();
			return res;
		}
		else
		{
			return -1;
		}
    }

    public static void Main(string[] args)
    {
        TrainComposition tree = new TrainComposition();
        tree.AttachWagonFromLeft(7);
        tree.AttachWagonFromLeft(13);
		tree.AttachWagonFromLeft(14);
		tree.AttachWagonFromLeft(15);
		tree.AttachWagonFromRight(19);
		tree.AttachWagonFromRight(20);
        Console.WriteLine(tree.DetachWagonFromRight()); // 20
        Console.WriteLine(tree.DetachWagonFromLeft()); // 15
		Console.WriteLine(tree.DetachWagonFromLeft()); // 14
		Console.WriteLine(tree.DetachWagonFromRight()); // 19
		Console.WriteLine(tree.DetachWagonFromRight()); // 7
		Console.WriteLine(tree.DetachWagonFromRight()); // 13
    }
}