package uniqueCodes;

//Java program to print all permutations of a 
//given string.
//https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

/*
					A|B|C
				/	  |    \
			/		  |			\
		/     		  |     		\
	A|B|C			B|A|C		  C|A|B
	/	\			/	\		  /	  \
A|B|C	A|C|B	B|A|C	B|C|A   C|A|B C|B|A 
*/

public class Permutation {
	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();
		Permutation permutation = new Permutation();
		permutation.permute(str, 0, n - 1);
		System.out.println("---------");
		permutation.permutationByVaibhav(str, 0, n-1);
	}

	/**
	 * permutation function
	 * 
	 * @param str
	 *            string to calculate permutation for
	 * @param l
	 *            starting index
	 * @param r
	 *            end index
	 */
	private void permute(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * 
	 * @param a
	 *            string value
	 * @param i
	 *            position 1
	 * @param j
	 *            position 2
	 * @return swapped string
	 */
	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public void permutationByVaibhav(String mytest, int start, int end) {
		if(start==end) // return if reached end
			return;
		for (int i = start; i <=end ; i++) {
			mytest = swap(mytest, i, start);
			if(start+1==end) // Print only leaf node.Check if it's last iteration
				System.out.println(mytest);
			permutationByVaibhav(mytest, start+1, end);
			swap(mytest, start, i); //swap back
		}
	}
}