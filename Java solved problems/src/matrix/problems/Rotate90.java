package matrix.problems;

public class Rotate90 {
	
	
	public static void rotar(Integer[][] matrix) {
			for (int i = 0; i < (matrix.length)/2; i++) {
				for(int j = 0; j< matrix[i].length;j++){
					int previousValue = matrix[i][j];
					matrix[i][j] = matrix[matrix.length-i-1][matrix.length-j-1];
					matrix[matrix.length-i-1][matrix.length-j-1] = previousValue;
					
				}
			}
			if(matrix.length%2 != 0){
				int i = matrix.length/2;
				for(int j = 0; j<matrix.length/2;j++){
					int prev = matrix[matrix.length/2][j];
					matrix[i][j] = matrix[i][matrix[i].length -j-1];
					matrix[i][matrix[i].length -j-1] = prev;
				}
			}
	}
	
	public static void printMatrix(Integer[][] matrix){
		
		for(int i = 0;i< matrix.length;i++){
			for(int j = 0;j<matrix[i].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {

		Integer[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("input:\n");
		printMatrix(matrix);
		System.out.println("\noutput:\n");
		rotar(matrix);
		printMatrix(matrix);
		
		
		Integer[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println("\ninput:\n");
		printMatrix(matrix2);
		System.out.println("\noutput:\n");
		rotar(matrix2);
		printMatrix(matrix2);
	}
}
