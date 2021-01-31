import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
			String S = "ababcbacadefegdehijhklij";
			List<Integer> result = sol.partitionLabels(S);
			System.out.println(result);
	}
	
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        
        if (S == null || S.length() == 0) {
            return result;
        }
        
        Map<Character, int[]> map = new HashMap<>();
        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            
            if (!map.containsKey(c)) {
                map.put(c, new int[] {i, i});
            } else {
                map.get(c)[1] = i;
            }
        }
        
        List<int[]> list = new ArrayList<>();
        list.addAll(map.values());

		//		for (int i = 0; i < list.size(); i++) {
		//	System.out.println(Arrays.toString(list.get(i)));
		//}
        
        
        return mergeIntervals(list);
    }
    
    List<Integer> mergeIntervals(List<int[]> intervals) {
        
        Collections.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        List<Integer> result = new ArrayList<>();
        
        int start = intervals.get(0)[0];
        int end = intervals.get(0)[1];
        int n = intervals.size();
        
        for (int i = 1; i < n; i++) {
			System.out.println("Start: "+start+", End: "+end);
            if (intervals.get(i)[0] <= end) {
                end = Math.max(end, intervals.get(i)[1]);
            } else {
                result.add(end - start + 1);
                start = intervals.get(i)[0];
                end = intervals.get(i)[1];
            }
        }
        
        result.add(end - start + 1);
        
        return result;
    }
}
