package uniqueCodes;

public class PrimeNumberOrNot {

	public static void main(String[] args) {
		System.out.println(isPrimeOrNot(25));
	}
//  a prime (except 2 and 3) is of form 6k - 1 or 6k + 1
//	and looks only at divisors of this form.
	
	public static boolean isPrimeOrNot(int num) {
		 if (num == 2)
		        return true;
		    if (num == 3)
		        return true;
		    if (num % 2 == 0)
		        return false;
		    if (num % 3 == 0)
		        return false;

		    int i = 5;
		    int w = 2;

		    while (i * i <= num){
		        if (num % i == 0)
		            return false;
		        i += w;
		        w = 6 - w;

		    }
		    return true;
	}
}
