package crackingcoding.arrays;

import java.util.Random;

public class SetRowColumnZero_1_8 {

	public static void main(String[] args) {
		int m=3,n=3;
		int[][] curr2dArray = new int[m][n];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				curr2dArray[i][j]= new Random().nextInt(10);
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(curr2dArray[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("\n Converted 2D array");
		
	}

}
