import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Point[] points = {new Point(1, 3), new Point(2, 4), new Point(3, 5), new Point(4, 6), new Point(5, 1), new Point(6, 2)};
        Arrays.sort(points);
        System.out.println(lis(points));
    }

    static int lis(Point[] points) {
        int n = points.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int best = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (points[i].x > points[j].x) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    best = Math.max(best, dp[i]);
                }
            }
        }

        return best;

    }

    static class Point implements Comparable<Point>
    {
        int x, y;  // x - north, y - south
        public Point(int x1, int y1) { x = x1; y = y1; }
        public int compareTo(Point p) {
            if (y != p.y) {
                return y-p.y;  // south
            } else {
                return x - p.x; // north
            }
        }
    }

}
