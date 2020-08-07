import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] arr ={{3, 2}, {-2, 2}};
        int result = minTimeToVisitAllPoints(arr);
        System.out.println(result);

    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int dist = 0;
        int N = points.length;
        for (int i = 0; i < N-1; i++) {
            int a1 = points[i][0];
            int b1 = points[i][1];
            int a2 = points[i+1][0];
            int b2 = points[i+1][1];

            int diff1 = Math.abs(a2-a1);
            int diff2 = Math.abs(b2-b1);

            dist += diff1 > diff2 ? diff1 : diff2;
        }

        return dist;

    }

}
