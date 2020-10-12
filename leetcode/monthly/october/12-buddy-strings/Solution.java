import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		String A = "aaaaaaabc";
		String B = "aaaaaaacb";
		boolean result = sol.buddyStrings(A, B);
		System.out.println(result);
    }
    
	public boolean buddyStrings(String A, String B) {
		if (A == null || B == null || A.length() != B.length() || A.length() < 2) {
			return false;
		}

		if (A.length() == 2 && B.length() == 2) {
			if (A.equals(B)) {
				if (A.charAt(0) != A.charAt(1)) {
					return false;
				} else {
					return true;
				}
			}
		}
		
		int misIndex1 = -1;
		int misIndex2 = -1;

		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != B.charAt(i)) {
				if (misIndex1 == -1) {
					misIndex1 = i;
				} else if (misIndex2 == -1) {
					misIndex2 = i;
				} else {
					return false;
				}
			}
		}

		if (misIndex1 == -1 || misIndex2 == -1) {
			if (A.length() > 26) {
				return true;
			} else if (misIndex1 != -1) {
              return A.charAt(misIndex1) == B.charAt(misIndex1);  // only one char mismatch  
            } else if (hasDuplicate(A)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (A.charAt(misIndex1) == B.charAt(misIndex2) && A.charAt(misIndex2) == B.charAt(misIndex1)) {
				return true;
			} else {
				return false;
			}
		}
	}

	boolean hasDuplicate(String str) {
		char[] map = new char[26];
		for (int i = 0; i < str.length(); i++) {
			int curIdx = str.charAt(i) - 'a';
			map[curIdx]++;

			if (map[curIdx] > 1) {
				return true;
			}
		}

		return false;
	}
}
