import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Interval> result = Arrays.asList(new Interval(1, 3), new Interval(6, 9));
		Interval newInterval = new Interval(2, 5);
		List<Interval> newResult = sol.insert(result, newInterval);
		System.out.println(newResult);
    }
    
    static class Interval {
		int start, end;
		
		public Interval(int s, int e) {
			start = s;
			end = e;
		}

		public String toString() {
			return start + " : " + end;
		}
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();

		if (intervals.size() == 0) {
			result.add(newInterval);
			return result;
		}
		
		for (Interval cur : intervals) {
			if (cur.end < newInterval.start) {
				result.add(cur);
			} else if (cur.start > newInterval.end) {
				result.add(newInterval);
				newInterval = cur;
			} else if (cur.end >= newInterval.start || cur.start <= newInterval.end) {
				newInterval = new Interval(Math.min(cur.start, newInterval.start), Math.max(cur.end, newInterval.end));
			}
		}

		result.add(newInterval);

		return result;
	}
}
