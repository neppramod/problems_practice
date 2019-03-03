import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Point[] points = {new Point(0,0), new Point(1,0), new Point(2,1), new Point(1,2), new Point(0,2)};
        double minCost = minCostTriangulation(points, points.length);
        System.out.println(minCost);

    }

    static class Point
    {
        int x, y;
        public Point(int x1, int y1) {x=x1; y=y1;}
    }

    static double minCostTriangulation(Point[] points, int n)
    {
        if (n < 3) return 0;

        double[][] table = new double[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (j < i+2)
                    table[i][j] = 0.0;
                else {
                    table[i][j] = Double.MAX_VALUE;
                    for (int k = i+1; k < j; k++) {
                    //res = Math.min(res, minCostTriangulation(points, i, k) + minCostTriangulation(points, k, j) + cost(points, i, k, j));
                        double res = table[i][k] + table[k][j] + cost(points, i, k, j);
                        if (table[i][j] > res) table[i][j] = res;
                    }
                }
            }
        }


        return table[0][n-1];
    }

    static double cost(Point[] points, int i, int k, int j)
    {
        return dist(points[i], points[k]) + dist(points[k], points[j]) + dist(points[j], points[i]);
    }

    static double dist(Point p1, Point p2)
    {
        double xsqr = (p2.x - p1.x) * (p2.x - p1.x);
        double ysqr = (p2.y - p1.y) * (p2.y - p1.y);
        return Math.sqrt(xsqr + ysqr);
    }
}
