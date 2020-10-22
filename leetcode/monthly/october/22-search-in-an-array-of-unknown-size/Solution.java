import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
         ArrayReader r = index -> {
			 switch(index) {
			 case 0: return -1;
			 case 1: return 0;
			 case 2: return 3;
			 case 3: return 5;
			 case 4: return 9;
			 case 5: return 12;
			 default: return 2147483647;
			 }
		 };

		 System.out.println(sol.search(r, 9));
    }

	public int search(ArrayReader reader, int target) {
		int l = 0, r = 2147483647;
		while (l < r) {
			int mid = l + (r - l) / 2;
			int cur = reader.get(mid);

			if (cur == target) {
				return mid;
			} else if (cur < target) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}

		return -1;
	}
}

interface ArrayReader {
	public int get(int index);
}
