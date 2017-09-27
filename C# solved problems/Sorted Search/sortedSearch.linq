<Query Kind="Program">
  <Namespace>System</Namespace>
</Query>


public class SortedSearch
{

	public static int CountLessThan(int[] sortedArray, int lessThan)
	{

		int maxIndex = sortedArray.Length;
		int minIndex = 0;
		int inspectIndex = 0;

		while (minIndex <= maxIndex)
		{
			inspectIndex = (maxIndex + minIndex) / 2;

			if (sortedArray[inspectIndex] >= lessThan)
			{
				maxIndex = inspectIndex - 1;
			}
			else
			{
				minIndex = inspectIndex + 1;
			}

		}

		return sortedArray[inspectIndex] < lessThan ? inspectIndex + 1 : inspectIndex;


	}

	public static int CountNumbers(int[] sortedArray, int lessThan)
	{
		if (sortedArray.Length == 0)
		{
			return 0;
		}
		else if (sortedArray.Length < 10)
		{
			for (int i = 0; i < sortedArray.Length; i++)
			{
				if (sortedArray[i] >= lessThan) { return i; }
			}
			return sortedArray.Length;
		}
		else
		{
			return CountLessThan(sortedArray, lessThan);
		}

	}


	public static void Main(string[] args)
	{
		Console.WriteLine(SortedSearch.CountNumbers(new int[] { 1, 3, 5, 7 }, 4));
	}
}