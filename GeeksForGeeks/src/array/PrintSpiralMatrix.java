package array;

public class PrintSpiralMatrix {

	public static void main(String[] args) {
		/*
		Input:
        1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
		
		Output: 
		1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
		 */
		int m = 4;
		int n = 4;
		int matrix[][] = { {1,  2,  3,  4},
						   {5,  6,  7,  8}, 
                           {9,  10, 11, 12},
                           {13, 14, 15, 16}
        };
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		printSpiral(matrix, m, n);
	}

	private static void printSpiral(int[][] matrix, int m, int n) {
		int row = 0;
		for (int j = 0; j < n-1; j++) {
			System.out.print(matrix[row][j]+" ");
		}
		int column = n-1;
		for (int i = 0; i < m-1; i++) {
			System.out.print(matrix[i][column]+" ");
		}
		row = m-1;
		for (int j = n-1; j > 0; j--) {
			System.out.print(matrix[row][j]+" ");
		}
		column = 0;
		for (int i = m-1; i >0; i--) {
			System.out.print(matrix[i][column]+" ");
		}
	}

}
