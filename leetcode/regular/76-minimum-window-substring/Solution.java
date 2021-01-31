import java.util.*;

public class Solution {
    public String minWindow(String s, String t) {
        // This is similar to smallest window contains character string (GFG)
        // Difference here is, instead of counting unique chars in s, we
        // use t
        // Here though t could contain duplicates, we need to handle the frequency
        
        
        if (s == null || s.length() == 0) {
            return "";
        } else if (t == null || t.length() == 0) {
            return "";
        }
        
        int[] tfreq = new int[256];
        
        for (int i = 0; i < t.length(); i++) {
            tfreq[t.charAt(i)]++;
        }


        
        int start = 0;
        int[] sfreq = new int[256];
        
        int found = 0;
        int minLength = Integer.MAX_VALUE;
        String smallestSubString = null;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sfreq[c]++;
            
            if (sfreq[c] == tfreq[c]) {
                found += sfreq[c];

            }

            
            if (found == t.length()) {
		
		
                // prune chars that have higher frequency
                while (sfreq[s.charAt(start)] > tfreq[s.charAt(start)]) {
                    sfreq[s.charAt(start)]--;
                    start++;
                }
		
		                
                int length = i - start + 1;

		
                if (minLength > length) {
                    minLength = length;
                    smallestSubString = s.substring(start, start + minLength);
                }
            }
        }
        
        return smallestSubString;
    }
    
    public static void main(String[] args) {
	Solution sol = new Solution();
	String s = "ADOBECODEBANC", t = "ABC";
	String result = sol.minWindow(s, t);
	System.out.println(result);
    }
}
