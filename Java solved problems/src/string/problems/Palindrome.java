package string.problems;

public class Palindrome {

	
	public static boolean IterativeIsPalindrome(String inputString){
		int i = 0;
		int j = inputString.length()-1;
		while(i<j){
			Character first = inputString.charAt(i); 
			Character last = inputString.charAt(j);
			if(!Character.isLetter(first) && !Character.isDigit(first)){
				i++;	
			}else if(!Character.isLetter(last) && !Character.isDigit(last)){
				j--;	
			}else{
				if(last.equals(first)){
					i++;
					j--;
				}else{
					return false;
				}
			}
			
		}
		return true;
	}
	
	public static boolean RecursiveIsPalindrome(String inputString,int i, int j){
		if(i >= j){
			return true;			
		}else{
			Character first = inputString.charAt(i); 
			Character last = inputString.charAt(j);
			if(!Character.isLetter(first) && !Character.isDigit(first)){
				return RecursiveIsPalindrome(inputString, i+1, j);	
			}else if(!Character.isLetter(last) && !Character.isDigit(last)){
				return RecursiveIsPalindrome(inputString, i, j-1);	
			}else{
				if(last.equals(first)){
					return RecursiveIsPalindrome(inputString, i+1, j-1);	
				}else{
					return false;
				}
			}
		}			
	}
	
	public static void main(String[] args) {
		String input1 = "101&%/&%/%/";
		System.out.println("input: "+ input1);
		System.out.println("output: "+IterativeIsPalindrome(input1));
		System.out.println("output: "+RecursiveIsPalindrome(input1,0,input1.length()-1));
		
		String input2 = "%&%/%&$/%&/)121&%/%/1";
		System.out.println("input: "+ input2);
		System.out.println("output: "+IterativeIsPalindrome(input2));
		System.out.println("output: "+RecursiveIsPalindrome(input2,0,input2.length()-1));
		
		String input3 = "neuquen";
		System.out.println("input: "+ input3);
		System.out.println("output: "+IterativeIsPalindrome(input3));
		System.out.println("output: "+RecursiveIsPalindrome(input3,0,input3.length()-1));
	}
}
