import java.util.*;
 
public class TwoSum
{
    public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		twoSum.add(1);
		twoSum.add(3);
		twoSum.add(5);
		System.out.println(twoSum.find(4));
		System.out.println(twoSum.find(7));
    }

	HashMap<Integer, Integer> map = new HashMap<>();
	
    /** Initialize your data structure here. */
    public TwoSum() {
        
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
		if (!map.containsKey(number)) {
			map.put(number, 1);
		} else {
			map.put(number, map.get(number) + 1);
		}
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key : map.keySet()) {
			int cur = value - key;

			if (map.containsKey(cur)) {
				if (cur == key && map.get(cur) < 2) {
					continue;
				}

				return true;
			}
		}

		return false;
    }
    
}
