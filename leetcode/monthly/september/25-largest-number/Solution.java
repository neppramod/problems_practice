import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] nums = { 121, 12 };
		String res = sol.largestNumber(nums);
		System.out.println(res);
		
    }
    
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        List<String> strList = getStringList(nums);
        Collections.sort(strList, new Comparator<String>() {
            public int compare(String s1, String s2) {
				return (s1 + s2).compareTo(s2 + s1);
            }
        });
        
        
        System.out.println(strList);
        
        StringBuilder sb = new StringBuilder();
        for (int i = strList.size()-1; i >= 0; i--) {
            sb.append(strList.get(i));
        }

		if (sb.length() > 0) {
			while(sb.length() > 0 && sb.charAt(0) == '0') {
				sb.deleteCharAt(0);
			}
		}
        return sb.toString();
    }
    
    List<String> getStringList(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int n : nums) {
            list.add(String.valueOf(n));
        }
        return list;
    }
    
}
