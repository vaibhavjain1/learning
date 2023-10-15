package amazon;
//https://www.geeksforgeeks.org/trapping-rain-water/

public class TappingWater {

	public static int TotalWater = 0;

	public static void findwater(int[] arr, int start, int end) {
		int i,j = -1;

		mainLoop:
		for (i = start + 1; i <= end; i++) {
			if (arr[start] <= arr[i]) {
				for (j = start; j < i; j++) {
					TotalWater+= arr[start] - arr[j];
				}
				break mainLoop;
			}
		}
		
		
		if(i<=end) {
			if(j==-1)
			findwater(arr, start+1, end);
			else
				findwater(arr, j, end);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 3, 0, 0, 2, 0, 4, 0, 2};
		findwater(arr, 0, arr.length - 1);
		System.out.println(TotalWater);
	}

}
