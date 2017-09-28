package string.problems;

public class ReplaceSpaces {

	public static String replaceSpaces(String s){
		String[] arraySplit = s.split(" ");
		String aux = "";
		for(int i = 0; i< arraySplit.length; i++) {
			aux += arraySplit[i];
			if(i != arraySplit.length-1)
				aux += "%20";
			}
		return aux;
	}
	
	public static void main(String[] args) {
		System.out.println("input: hello, how are you doing?");
		String input = "hello, how are you doing?";
		System.out.println("output: ");
		System.out.println(replaceSpaces(input));
	}
	
}
