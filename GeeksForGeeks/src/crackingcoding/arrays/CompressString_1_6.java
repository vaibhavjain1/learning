package crackingcoding.arrays;

/*
 1.6 Implement a method to perform string compression using the counts of repeated
     characters. If compressed string would not become smaller then return original.
     ex. aabcccccaaa -> a2b1c5a3
 */

public class CompressString_1_6 {

	public static void main(String[] args) {
		String tobeCompressed1 = "aabcccccaaa";
		String tobeCompressed2 = "abcccccaaadee";
		String tobeCompressed3 = "abcccccaaade";
		System.out.println(getCompressedString(tobeCompressed1));
		System.out.println(getCompressedString(tobeCompressed2));
		System.out.println(getCompressedString(tobeCompressed3));
	}
    
	// The solution lies in using String builder as string concatenation uses
	// o(n2). String builder creates new array only when neccessary
	public static String getCompressedString(String tempi){
		char[] toCompress = tempi.toCharArray();
		StringBuilder sb = new StringBuilder();
		char currChar = toCompress[0];
		int currCount = 1;
		for (int i = 1; i < toCompress.length; i++) {
			if(i==toCompress.length-1){
				if(toCompress[i]==toCompress[i-1]){
					sb.append(currChar+""+(currCount+1));
				}
				else{
					sb.append(currChar+""+currCount);
					sb.append(toCompress[i]+""+1);
				}
			}
			else if(currChar==toCompress[i]){
				currCount++;
			}
			else{
				sb.append(currChar+""+currCount);
				currChar = toCompress[i];
				currCount = 1;
			}
		}
		if(tempi.length()<=sb.length())
			return tempi;
		else
			return sb.toString();
	}
}
