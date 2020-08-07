import java.util.*;

public class Solution1
{
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2)
            return null;
            
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] output = new int[2];

        map.put(target - nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                output[0] = map.get(nums[i]);
                output[1] = i;
                return output;
            } else {
                map.put(target - nums[i], i);
            }
        }
        
        return null;
    }
}
