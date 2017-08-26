package datascience.tutorial.graph;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class PathFinding
{
    private static class Node
    {
        int x1, y1, x2, y2;
        int steps;

        public Node(int x11, int y11, int x22, int y22, int steps) { x1 = x11; y1 = y11; x2 = x22; y2 = y22; this.steps = steps; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (x1 != node.x1) return false;
            if (y1 != node.y1) return false;
            if (x2 != node.x2) return false;
            if (y2 != node.y2) return false;
            return steps == node.steps;
        }

        @Override
        public int hashCode() {
            int result = x1;
            result = 31 * result + y1;
            result = 31 * result + x2;
            result = 31 * result + y2;
            result = 31 * result + steps;
            return result;
        }
    }

    private boolean[][][][] visited = new boolean[20][20][20][20];

    private void pushToQueue(Queue<Node> queue, Node node)
    {
        if (!visited[node.x1][node.y1][node.x2][node.y2]) {
            queue.add(node);
            visited[node.x1][node.y1][node.x2][node.y2] = true;
        }
    }

    public int noOfTurns(String[] board)
    {
        // start, queue, boundary condition, check for true swap, loop each condition and add to queue, if they don't currently overlap
        Node start = getStart(board);
        if (start.x1 == -1)
            return -1;

        int width = board[0].length();
        int height = board.length;

        Queue<Node> queue = new LinkedList<>();
        pushToQueue(queue, start);

        while (!queue.isEmpty()) {
            Node top = (Node)queue.poll();

            if (top.x1 < 0 || top.x1 >= height && top.x2 < 0 || top.x2 >= height || top.y1 < 0 || top.y1 >= width || top.y2 < 0 || top.y2 >= width) continue;
            if (start.x1 == top.x2 && start.y1 == top.y2 && start.x2 == top.x1 && start.y2 == top.x2) return top.steps;

            for (int dx1 = -1; dx1 <= 1; dx1++) {
                for (int dy1 = -1; dy1 <= 1; dy1++) {
                    for (int dx2 = -1; dx2 <= 1; dx2++) {
                        for (int dy2 = -1; dy2 <= 1; dy2++) {

                            // make sure they did not just swap spaces
                            if (top.x1 == top.x2 + dx2 && top.y1 == top.y2 + dy2 && top.x2 == top.x1 + dx1 && top.y2 == top.y1 + dy1)
                                continue;

                            if (top.x1 + dx1 < 0 || top.y1 + dy1 < 0 || top.x2 + dx2 < 0 || top.y2 + dy2 < 0) continue;
                            if (top.x1 + dx1 > 19 || top.y1 + dy1 > 19 || top.x2 + dx2 > 19 || top.y2 + dy2 > 19) continue;

                            pushToQueue(queue, new Node(top.x1 + dx1, top.y1 + dy1, top.x2 + dx2, top.y2 + dy2, top.steps + 1));
                        }
                    }
                }
            }
        }
        
        return -1;
    }

    private Node getStart(String[] board)
    {
        Node node = null;

        if (board.length > 0 && board[0].length() > 0) {
            int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
            for (int i = 0; i < board.length; i++) {
                if (board[i].contains("A")) {
                    x1 = i;
                    y1 = board[i].indexOf('A');
                }

                if (board[i].contains("B")) {
                    x2 = i;
                    y2 = board[i].indexOf('B');
                }
            }

            if (x1 > -1 && y1 > -1 && x2 > -1 && y2 > -1)
                node = new Node(x1, y1, x2, y2, 0);
        }

        return node;
    }

    public  static void main(String[] args)
    {
        PathFinding pf = new PathFinding();
        System.out.println(pf.noOfTurns(new String[] {"....",
                ".A..",
                "..B.",
                "...."}));
    }
}
