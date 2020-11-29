import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        Solution sol = new Solution();
        System.out.println(sol.minMeetingRooms(meetings));
    }

    public int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
        });

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;

        for (int[] intv : intervals) {
            if (heap.isEmpty()) {
                count++;
                heap.add(intv[1]);
            } else {
                if (intv[0] >= heap.peek()) {
                    heap.poll(); // can use the meeting room
                } else {
                    count++;
                }

                heap.add(intv[1]);
            }
        }

        return count;
    }
}
