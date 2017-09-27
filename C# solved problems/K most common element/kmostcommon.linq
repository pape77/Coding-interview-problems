<Query Kind="Program">
  <Namespace>System</Namespace>
</Query>

public class Common
{
	public static int KthMostCommon(int[] a, int k)
	{
		var sorted = a.ToList();
		sorted.Sort();
		var dicc = new Dictionary<int, int>();
		foreach (var elem in sorted)
		{
			if (dicc.Keys.Contains(elem))
			{
				dicc[elem]++;
			}
			else 
			{
				dicc.Add(elem,1);
			}
		}
		
		var values = dicc.Values.ToList();
		values.Sort();
		values.Reverse();
		var selectedValue = 0;
		if (k >= values.Count)
		{
			selectedValue = values.ElementAt(values.Count - 1);
		}
		else 
		{
			selectedValue = values.ElementAt(k-1);
		}
		
		foreach (var key in dicc.Keys)
		{
			if (dicc[key] == selectedValue)
			{
				return key;
			}
		}
		return -1;
	}

	public static void Main(string[] args)
	{
		int x = KthMostCommon(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
		Console.WriteLine(x);
	}
}