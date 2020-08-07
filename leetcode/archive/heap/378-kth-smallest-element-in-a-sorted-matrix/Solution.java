import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] matrix = {
            {1, 2},
            {1, 3},
        };
        int k = 2;

        int result = kthSmallest(matrix, k);

        System.out.println(result);

    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int h = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (queue.size() < k) {
                    queue.add(matrix[i][j]);
                } else if (matrix[i][j] < queue.peek()) {
                    queue.poll();
                    queue.add(matrix[i][j]);
                }
            }
        }

        return queue.poll();
    }

    static void pA1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pA1(arr[i]);
        }
    }
}
