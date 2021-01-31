import java.util.*;

public class DecodeXOredPermutation {
    public static void main(String[] args) {
	    DecodeXOredPermutation sol = new DecodeXOredPermutation();
		int[] encoded = {3, 1};
		int[] result = sol.decode(encoded);
		System.out.println(Arrays.toString(result));
	}


    public int[] decode(int[] encoded) {
		// given numbers from 1 to n+1 get all numbers back that were encoded to encoded
		// we need to get the first number, after that we can use that to generate rest
		// to get first number xorg result of 1 to n with encoded[0] and encoded[n-1]

		int firstnumber = 0;
		int n = encoded.length + 1;  // n+1
		for (int i = 1; i <= n; i++) {
			firstnumber ^= i;
		}

		for (int i = 1; i < encoded.length; i+= 2) {
			firstnumber ^= encoded[i];
		}
		
		System.out.println("First: " + firstnumber);

		int[] result = new int[n];
		result[0] = firstnumber;
		
		for (int i = 1; i < n; i++) {
			result[i] = result[i-1] ^ encoded[i-1];
		}

		return result;
    }
}
