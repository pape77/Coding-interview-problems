<Query Kind="Program" />

void Main()
{
	Console.WriteLine(Solution.solution("a0Ba"));//2
	Console.WriteLine(Solution.solution("a0bb"));//-1
	Console.WriteLine(Solution.solution("B0bb"));//1
	Console.WriteLine(Solution.solution("B"));//1
	Console.WriteLine(Solution.solution("0"));//-1
	Console.WriteLine(Solution.solution("0bB"));//2
	Console.WriteLine(Solution.solution("0bbB"));//3
	Console.WriteLine(Solution.solution("0bb"));//-1

}

public class Solution
{
	public static int solution(string S)
	{
		int beginPointer = 0;
		var maxLength = -1;
		var hasUpper = false;
		for (int endPointer = 0; endPointer < S.Length; endPointer++)
		{
			if (!isAlfa(S[endPointer]))
			{
				if (hasUpper)
				{
					maxLength = S.Substring(beginPointer, endPointer - beginPointer).Length > maxLength ? S.Substring(beginPointer, endPointer - beginPointer ).Length : maxLength;
				}
				hasUpper = false;
				beginPointer = endPointer+1;
				
			}
			else if (isUpper(S[endPointer]))
			{
				hasUpper = true;
			}

			if (endPointer == S.Length - 1)
			{
				if (hasUpper)
				{
					maxLength = S.Substring(beginPointer, endPointer - beginPointer + 1).Length > maxLength ? S.Substring(beginPointer, endPointer - beginPointer + 1).Length : maxLength;
				}
			}

		}
			return maxLength;
	}

	public static bool isAlfa(char a)
	{
		var nums = "0123456789";
		for (int i = 0; i < nums.Length; i++)
		{
			if (nums[i] == a) { return false;}
		}
		return true;
	}

	public static bool isUpper(char a)
	{
		var uppers = "QWERTYUIOPASDFGHJKLZXCVBNM";
		for (int i = 0; i < uppers.Length; i++)
		{
			if (uppers[i] == a) { return true; }
		}
		return false;
	}
}