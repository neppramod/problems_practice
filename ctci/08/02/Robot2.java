import java.util.*;

public class Robot2
{
    //static int count = 0;
    public static void main(String[] args)
    {
        int[][] matrix = {
            {0, -1, -1, 0,  0, 0, 0},
            {0,  0, -1, 0,  0, 0, 0},
            {-1, 0, -1, 0,  0, 0, 0},
            {-1, 0, -1, 0,  0, 0, 0},
            {0,  0,  0, 0,  0, 0, 0},
        };


        HashSet<Point> failedPoints = new HashSet<>();
        List<Point> points = new ArrayList<>();
        boolean hasPath = getPath(matrix, 0, 0, points, failedPoints);
        System.out.println("Has Path: " + hasPath);
        for (Point point : points) {
            System.out.print(point);
        }

        // System.out.println("\nCount: " + count);

    }

    static boolean getPath(int[][] matrix, int r, int c, List<Point> points, HashSet<Point> failedPoints)
    {
        int m = matrix.length;
        int n = matrix[0].length;

        Point point = new Point(r, c);
        if (r > m-1 || c > n-1 || matrix[r][c] == -1) return false;
        if(failedPoints.contains(point)) return false;
        //count++;

        if (r == m-1 && c == n-1) {
            points.add(point);
            return true;
        }

        boolean path = getPath(matrix, r+1, c, points, failedPoints) || getPath(matrix, r, c+1, points, failedPoints);
        if (path) {
            points.add(point);
            return true;
        } else {
            failedPoints.add(point);
            return false;
        }
    }

    static class Point
    {
        int x, y;
        public Point(int x1, int y1) { x = x1; y = y1;}
        public String toString() { return "(" + x + ", " + y + "), "; }

        @Override
        public boolean equals(Object o) {
            Point p1 = (Point) o;
            if (p1.x == x && p1.y == y) return true;
            return false;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result =31*result+ x;
            result = 31 * result + y;
            return result;
        }
    }

}
