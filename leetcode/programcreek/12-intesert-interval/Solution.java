import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        //int[][] arr = {{1, 2}, {3, 7}, {6, 7}, {8, 10}, {12, 16}};
        //int[][] output  = sol.insert(arr, new int[]{4, 8});
	int[][] arr = {{1, 5}};
	int[][] output = sol.insert(arr, new int[]{6, 8});

	for (int i = 0; i  < output.length; i++) {
	    System.out.println(Arrays.toString(output[i]));
	}
    }

    private class Interval {
        int x, y;
        public Interval(int x1, int y1) {x = x1; y = y1;}
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
       if (intervals == null || newInterval == null || intervals.length == 0 || newInterval.length == 0) {
           return intervals;
       }
        
       
        int n = intervals.length;
        List<Interval> list = new ArrayList<>();
        Interval newInt = new Interval(newInterval[0], newInterval[1]);
        int i = 0;
        
      while (i < n) {
           if (withinRange(intervals, i, newInt)) {
               int start = i;
               int j = start;
               
               while (j + 1 < n && withinRange(intervals, j+1, newInt)) {
                   j++;
               }

	       // System.out.println("J: " + j);
              
               int x = Math.min(intervals[start][0], newInt.x);
               int y = Math.max(intervals[j][0], newInt.y);
               list.add(new Interval(x, y));
               i = j+1;
              
              
           } else {
                   list.add(new Interval(intervals[i][0], intervals[i][1]));
                   i++;
           }
       }
        
       int[][] output = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            output[i][0] = list.get(i).x;
            output[i][1] = list.get(i).y;
        }
    
        return output;
    }

    boolean withinRange(int[][] intervals, int i, Interval newInt) {
        int x1 = intervals[i][0];
	int y1 = intervals[i][1];

	int x2 = newInt.x;
	int y2 = newInt.y;

	return (x1 <= x2 && x2 <= y1) || (x1 >= x2 && y1 <= y2) || (x1 <= y2 && y2 <= y1);
    }
}
