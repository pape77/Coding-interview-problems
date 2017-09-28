package string.problems;


public class Parser {

	
	public static void parseString(String jsonString){
		int cantTabs = 0;
		for(int i =0;i < jsonString.length();i++){
			Character jsonChar = jsonString.charAt(i);
			if(jsonChar.equals('{') || jsonChar.equals('[')){
				System.out.println(jsonChar);
				cantTabs++;
				printTabs(cantTabs);
			}else if(jsonChar.equals('}') || jsonChar.equals(']')){
				System.out.println("");
				cantTabs--;
				printTabs(cantTabs);
				System.out.print(jsonChar);
			}else if(jsonChar.equals(',')){
				System.out.println(',');
				printTabs(cantTabs);
			}else {
				System.out.print(jsonChar);
			}
		}
	}

	private static void printTabs(int cantTabs) {
		for(int t=0;t< cantTabs;t++){
			System.out.print(" ");
		}
	}
	
	public static void main(String[] args) {
		String jsonString = "{\"J\":[5,5],\"0\":\"N\"}";
		System.out.println("input: "+jsonString);
		System.out.println("output: ");
		parseString(jsonString);
	}
	
}
