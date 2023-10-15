package crackingcoding.arrays;

/*
 1.3 Write a method to replace all spaces in a string with '%20' without extra array.
 Assuming that string has suffcient space to hold extra chars.
 */

public class ReplaceSpace_1_3 {

	public static void main(String[] args) {
		String stringToChange = "My Name is VJ      ";
		System.out.println(ReplaceSpaces(stringToChange));
	}

	public static String ReplaceSpaces(String currString) {
		int noOfSpaces = 0;
		char[] currArray = currString.toCharArray();
		// index of last element
		int indexofLastelement = -1;
		for (int i = currArray.length - 1; i > 0; i--) {
			if (currArray[i] != ' ') {
				indexofLastelement = i;
				break;
			}
		}
		// count no. of spaces
		for (int i = 0; i < indexofLastelement; i++) {
			if (currArray[i] == ' ')
				noOfSpaces++;
		}
		for (int i = indexofLastelement; i > 0; i--) {
			if (currArray[i] != ' ') {
				currArray[i + 2 * noOfSpaces] = currArray[i];
			} else {
				currArray[i + 2 * noOfSpaces] = '%';
				currArray[i + 2 * noOfSpaces - 1] = '0';
				currArray[i + 2 * noOfSpaces - 2] = '2';
				if (noOfSpaces != 0)
					noOfSpaces--;

			}
		}
		return new String(currArray);
	}
}
