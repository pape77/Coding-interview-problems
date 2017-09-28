<Query Kind="Program" />

void Main()
{
	Console.WriteLine(Solution.solution(123));
}

public class Solution { 

	public static int solution(int N)
	{
		var binaryRep = Convert.ToString(N, 2);

		binaryRep.Trim(new char[] { '0' });
		
		var seen1 = false;
		var maxCount = 0;
		var currentCount = 0;
		
		for (int i = 0; i < binaryRep.Length; i++)
		{
			if (binaryRep[i] == '1' && !seen1)
			{
				seen1 = true;
			}
			else if (binaryRep[i] == '1')
			{
				if (currentCount > maxCount)
				{
					maxCount = currentCount;
				}
				currentCount = 0;
			}
			else
			{
				currentCount++;
			}
		}
		
		return maxCount;
	}

}

// Define other methods and classes here
