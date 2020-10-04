import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
         
    }
    
    public int maxDistance(List<List<Integer>> arrays) {
        if (arrays == null || arrays.size() < 2) {
            return 0;
        }
        
		int min = arrays.get(0).get(0);
		int max = arrays.get(0).get(arrys.get(0).size()-1);
		int res = Integer.MIN_VALUE;
		
		for (int i = 1; i < arrays.size(); i++) {
			int curMin = arrays.get(i).get(0);
			int curMax = arrays.get(i).get(arrays.get(i).size()-1);

			res = Math.max(max, max - curMin);
			res = Math.max(max, min - curMax);

			min = Math.min(min, curMin);
			max = Math.max(max, curMax);
		}

		return res;
    }
}
