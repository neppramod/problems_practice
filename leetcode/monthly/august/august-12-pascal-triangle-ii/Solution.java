import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		System.out.println(sol.getRow(4));         
    }
    
    public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();

		if (rowIndex < 0) {
			return result;
		}

		result.add(1);

		if (rowIndex == 0) {
			return result;
		}

		result.add(1);

		if (rowIndex == 1) {
			return result;
		}

		
		for (int i = 2; i <= rowIndex; i++) {
		    ArrayList<Integer> tmp = new ArrayList<>();
			tmp.add(1);
			tmp.add(1);

			for (int j = 1; j < i; j++) {
				tmp.add(j, result.get(j - 1) + result.get(j));
			}

			result = tmp;
		}

		return result;
		
    }
}
