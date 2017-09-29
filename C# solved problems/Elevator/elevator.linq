<Query Kind="Program" />

void Main()
{
	Console.WriteLine(Solution.solution(new int[] { 60, 80, 40 }, new int[] {2,3,5}, 5,2,200));

	Console.WriteLine(Solution.solution(new int[] { 60, 80, 40 }, new int[] { 2, 2, 2}, 5, 5, 150));
}

public class Solution
{
	public static int solution(int[] A, int[] B, int M, int X, int Y)
	{
		var currentWeight = 0;
		var floorsToCover = new HashSet<int>();
		var pathCount = 0;
		var peopleIn = 0;
		for (int i = 0; i < A.Length; i++)
		{
			//peso

			if (currentWeight + A[i] <= Y && peopleIn + 1 <= X)
			{
				//piso
				floorsToCover.Add(B[i]);
				
				currentWeight += A[i];
				peopleIn ++;
			}
			else
			{
				pathCount += floorsToCover.Count+1;
				floorsToCover = new HashSet<int>();
				currentWeight = 0;
				peopleIn = 0;
				i--;
			}
		}
		if (floorsToCover.Count > 0)
		{
			pathCount += floorsToCover.Count+1;
		}
		return pathCount;
	}
}