package string.problems;

public class RemoveDuplicates {

	public static void removeDuplicates(Character[] input){
		int insertCounter = 0;
		boolean isDuplicated = false;
		
		for(int i=0;i< input.length;i++){
			for(int j = 0; j < i;j++){
				if(input[j].equals(input[i])){
					isDuplicated = true;
					break;
				}
			}
			if(!isDuplicated){
				input[insertCounter] = input[i];
				insertCounter++;
			}
			isDuplicated = false;
		}
		input[insertCounter] = '\0';
	}
	
	public static void printCharArray(Character[] array){
		
		for(int i = 0 ; i < array.length;i++){
			
			System.out.print(array[i]);
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		Character[] input1 = {'o','o','s','s','o','h','c','a','h','t','o','a','h'};
		System.out.println("input: ");
		printCharArray(input1);
		System.out.println("output: ");
		removeDuplicates(input1);
		printCharArray(input1);
		
		Character[] input2 = {'t','h','i','s','i','s','a','t','e','s','t'};
		System.out.println("input: ");
		printCharArray(input2);
		System.out.println("output: ");
		removeDuplicates(input2);
		printCharArray(input2);
	}
}
