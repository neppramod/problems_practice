import java.util.*;

public class Robot
{
    static boolean path(int r, int c, int[][] matrix, ArrayList<Point> list, HashSet<Point> failedPoints)
    {
        if (r < 0 || c < 0 || matrix[r][c] == -1) return false;
        if (failedPoints.contains(new Point(r, c))) return false;

        if (r == 0 && c == 0) { list.add(new Point(r, c)); return true;}
        if (path(r-1, c, matrix, list, failedPoints) || path(r, c-1, matrix, list, failedPoints)) {
            list.add(new Point(r, c));
            return true;
        } else {
            failedPoints.add(new Point(r, c));
            return false;
        }
    }

    static class Point
    {
        int x, y;
        public Point(int x1, int y1) { x = x1; y = y1;}
        public String toString() { return "X: " + x + ", Y: " + y; }

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

    public static void main(String[] args)
    {
        int[][] matrix = {
            {0, -1, -1, 0,  0, 0, 0},
            {0,  0, -1, 0,  0, 0, 0},
            {-1, 0, -1, 0,  0, 0, 0},
            {-1, 0, -1, 0,  0, 0, 0},
            {0,  0,  0, 0,  0, 0, 0},
        };

        int r = matrix.length;
        int c = matrix[0].length;
        ArrayList<Point> list = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();

        System.out.println(path(r-1, c-1, matrix, list, failedPoints));

        for (Point p : list) {
            System.out.println(p);
        }

        System.out.println("Failed");
        for (Point p : failedPoints) {
            System.out.println(p);
        }
    }
}
