import java.util.*;
 
public class DigitQueries {
    public static void main(String[] args) {
	    DigitQueries sol = new DigitQueries();
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
 
		while (q-- > 0) {
			long k = sc.nextLong();
			System.out.println(sol.digitQueries(k));
		}
		sc.close();
	}
	
    public int digitQueries(long k) {
		// length of digits of current number, increases by 10
		// start is the start of current range, here 1
		// count is count of numbers in range
		// e.g 1 to 9 = 9, 10 to 99 = 90, 100 to 999 = 900
		long len = 1, start = 1, count = 9;
 
		while (k > len * count) {
			k -= len * count;
 
			len += 1;  // from 1->9 to 10->99 len change from 1 to 2
			count *= 10;  // count of numbers 9, 90, 900 and so on
			start *= 10;  // start 1, 10, 100, 1000 and so on
		}
 
		// now move start to the actual number
		start += (k - 1) / len;
 
		// current number could be more than 1 digits
		// so get to the actual digit
		String s = String.valueOf(start);
		return Character.getNumericValue(s.charAt((int)((k - 1) % len)));
	}
}
