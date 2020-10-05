import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int input = 100000000;
		int res = sol.bitwiseComplement(input);
		System.out.println(res);
    }
    
    public int bitwiseComplement(int N) {

		if (N == 0) {
            return 1;
        }
        	int cur = N;
		int res = 1;
		while (cur != 0) {
			res = res << 1;
			res = res | 1;
			cur >>=1;
		}

		System.out.println(res);
		res = res >>= 1;
		return N ^ res;
    }
}
