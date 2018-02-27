package crackingcoding.arrays;

/*
    1.1 Implement an algorithm to determine if a string has all unique characters.
    Without using Datastructure/collection.
 */
public class UniqueChars_1_1 {

	public static void main(String[] args) {
		String stringToCheck1 = "abcdefghaijkl";
		String stringToCheck2 = "abcdefghijklmnop";
		System.out.println(checkUniquenessWithoutDatastructure(stringToCheck1));
		System.out.println(checkUniquenessWithoutDatastructure(stringToCheck2));
	}

	// without Collection
	public static boolean checkUniquenessWithoutCollections(String currString){
		currString = currString.toLowerCase();
		char[] currArray = currString.toCharArray();
		boolean[] b = new boolean[currArray.length];

		for(int i =0; i< currArray.length; i++){
			int j = currArray[i]-97;
			if(b[j])
				return false;
			else
				b[j] = true;
		}
		return true;
	}
	
	//without datastructure
	public static boolean checkUniquenessWithoutDatastructure(String currString){
		char[] currArray = currString.toCharArray();
		int checker = 0;
		for(int i=0;i<currArray.length;i++){
			int j = currArray[i];
			// Making the character to uppercase
			if(j<97)
				j+=26;
			// Getting index
				j-=97;
			if((checker & (1 << j)) > 0){
				// for e - shifting 1 to 5 bits -> 10000 & then AND to check if it
				// is already present
				return false;
			}else{
				checker |= (1 << j);
			}
		}
		return true;
	}
}
