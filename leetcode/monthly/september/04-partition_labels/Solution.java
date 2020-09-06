import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		String s = "ababfeefhijkh";
		
		List<Integer> result = sol.partitionLabels(s);
		System.out.println(result);
    }

	public List<Integer> partitionLabels(String S) {


		HashMap<Character, int[]> map = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			int[] arr = map.get(c);

			if (arr == null) {
				arr = new int[]{i, i};
				map.put(c, arr);
			} else {
				arr[1] = i;
			}
		}

		ArrayList<int[]> list = new ArrayList<>();
		list.addAll(map.values());
		Collections.sort(list, Comparator.comparing((int[] arr) -> arr[0]));
		List<Integer> result = mergeIntervals(list);
		return result;
		
	}
	
    List<Integer> mergeIntervals(List<int[]> intervals) {
		int[] t = intervals.get(0);
		List<Integer> result = new ArrayList<>();

		for (int i = 1; i < intervals.size(); i++) {
			int[] range = intervals.get(i);

			if (range[1] <= t[1]) {
				continue;
			} else if (range[0] > t[1]) {
				result.add(t[1] - t[0] + 1);
				t = range;
			} else {
				t[1] = range[1];
			}
		}

		result.add(t[1] - t[0] + 1);
		return result;
	}
}
