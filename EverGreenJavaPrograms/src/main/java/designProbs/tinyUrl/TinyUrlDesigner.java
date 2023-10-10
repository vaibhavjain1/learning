package designProbs.tinyUrl;

public class TinyUrlDesigner {
	private static final String ALPHABET_MAP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789" ;
	private static final int BASE = ALPHABET_MAP.length() ;

	public static String encode ( int IndexNum ) {
		StringBuilder sb = new StringBuilder() ;
		
		while ( IndexNum > 0 ) {
			sb.append ( ALPHABET_MAP.charAt ( IndexNum % BASE ) ) ;
			IndexNum /= BASE ;
		}
		return sb.reverse().toString() ;
	}

	public static int decode ( String str ) {
		int Num = 0 ;

		for ( int i = 0, len = str.length(); i < len; i++ ) {
			Num = Num * BASE + ALPHABET_MAP.indexOf ( str.charAt(i) ) ;
		}
		return Num ;
	}

	public static void main ( String[] args ) {
		System.out.println ( "Encoding for 123 is " + encode(123) ) ;
		System.out.println ( "Decoding for b9 is " + decode ("b9" ) ) ;
	}
}
