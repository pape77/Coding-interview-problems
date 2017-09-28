package matrix.problems;

import java.util.LinkedList;
import java.util.List;

public class ZerosMatrix {

	public static void generateZeros(Integer[][] matrix, int n, int m){
		List<Integer> zeroRows = new LinkedList<Integer>();
		List<Integer> zeroColumns = new LinkedList<Integer>();
		for(int i = 0;i< n;i++){
			for(int j=0 ; j<m;j++){
				if(matrix[i][j] == 0){
					zeroRows.add(i);
					break;
				}
			}
		}
		for(int j = 0;j<m;j++){
			for(int i=0;i< n;i++){
				if(matrix[i][j] == 0){
					zeroColumns.add(j);
					break;
				}
			}
		}
		setRowsToZeros(zeroRows,matrix,m);
		setColumnsToZeros(zeroColumns,matrix,n);
	}
	
	
	
	private static void setColumnsToZeros(List<Integer> zeroColumns,Integer[][] matrix, int n) {
		for(Integer j : zeroColumns){
			for(int i=0;i<n;i++){
				matrix[i][j]=0;
			}
		}
	}



	private static void setRowsToZeros(List<Integer> zeroRows, Integer[][] matrix, int m) {
		for(Integer i : zeroRows){
			for(int j=0;j<m;j++){
				//set rows to 0
				matrix[i][j] = 0;
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

		Integer[][] matrix = {{1,2,3,3},{4,5,6,8},{7,0,9,10}};
		System.out.println("input:\n");
		printMatrix(matrix);
		System.out.println("\noutput:\n");
		generateZeros(matrix,3,4);
		printMatrix(matrix);
	}
}
