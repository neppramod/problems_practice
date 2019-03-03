import java.util.*;

public class Solution
{
    static class Node {
        int data;
        int nextRow;
        int nextCol;

        public Node(int d, int nR, int nC) { data = d; nextRow = nR; nextCol = nC; }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int arr[][] = {
            {4, 7, 9, 12, 15},
            {0, 8, 10, 14, 20},
            {6, 12, 16, 30, 50}
        };
        int k = arr.length;
        int N = arr[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
                public int compare(Node n1, Node n2) {
                    return n1.data - n2.data;
                }
            });

        int max = 0;
        int min = 0;
        int range = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            pq.add(new Node(arr[i][0], i, 1));
            max = Math.max(max, arr[i][0]);
        }

        int start = -1, end = -1;
        while(true) {
            Node n = pq.poll();
            min = n.data;

            if (range > max - min + 1) {
                range = max - min + 1;
                start = min;
                end = max;
            }

            int nextRow = n.nextRow;
            int nextCol = n.nextCol;

            if (n.nextCol < N) {
                pq.add(new Node(arr[nextRow][nextCol], nextRow, nextCol + 1));
                max = Math.max(max, arr[nextRow][nextCol]);
            } else {
                break;
            }
        }

        System.out.println(start + ", " + end);

    }
}
