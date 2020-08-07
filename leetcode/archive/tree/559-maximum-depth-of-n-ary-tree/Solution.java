import java.util.*;


class Solution {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public static int maxDepth(Node root) {
        if (root != null) {
            int maxDepth = 0;
            if (root.children != null) {
                for (Node n : root.children) {
                    maxDepth = Math.max(maxDepth, maxDepth(n));
                }
            }
            return 1 + maxDepth;
        } else {
            return 0;
        }
    }

    static Node c(int val) {
        Node n = new Node(val);
        return n;
    }

    public static void main(String[] args) {
        Node r = c(1);
        Node t = c(3);
        t.children = Arrays.asList(c(5), c(6));
        r.children = Arrays.asList(t, c(2), c(4));
        int depth = maxDepth(r);
        System.out.println(depth);
    }
}
