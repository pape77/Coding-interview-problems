<Query Kind="Program" />

void Main()
{
	
}

public class Solution 
{
	public static int solution(int[] A)
	{
		var dicc =  new Dictionary<int,int>();
		
		for (int i = 0; i < A.Length; i++)
		{
			if (dicc.Keys.Contains(A[i]))
			{
				dicc[A[i]]++;
			}
			else
			{
				dicc.Add(A[i],1);
			}
		}
		
		var oddKey = dicc.Keys.Single(k => dicc[k] % 2 != 0);
		
		return oddKey;
		
	}
}
