import java.util.*;

public class MaxNonOverlapping
{
    static class Point
    {
        int start;
        int end;

        public Point(int s, int e) { start = s; end = e; }
        public String toString() { return "{Start: " + start + ", End: " + end + "}"; }
        public boolean equals(Object o)
        {
            Point p = (Point) o;
            return p.start == start && p.end == end;
        }
    }
    
    static int maxNonOverlappingSum(Point[] A, int index, ArrayList<Point> points)
    {
        if (index >= A.length)
            return 0;

        Point cur = A[index];
        points.add(cur);
        int max = cur.end-cur.start;
        for (int i = index+1; i < A.length; i++) {
            Point x = A[i];
            if (x.start > cur.end) {
                int mx = (cur.end - cur.start) + maxNonOverlappingSum(A, i+1, points);                                
                if (mx > max) {
                    max = mx;   
                }
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        Point[] A = {new Point(600, 830), new Point(800, 900), new Point(900, 1100), new Point(900, 1130), new Point(1030, 1400), new Point(1230, 1400)};
        ArrayList<Point> points = new ArrayList<>();
        int max = maxNonOverlappingSum(A, 0, points);
        System.out.println("Max: " + max);
        System.out.println(points);
        
    }
    
}
