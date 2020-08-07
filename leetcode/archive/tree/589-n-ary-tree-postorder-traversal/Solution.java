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

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postorder(list, root);
        return list;
    }

    static void postorder(List<Integer> list, Node root) {
        if (root == null) {
            return;
        } else {

            if (root.children != null) {
                for (Node n : root.children) {
                    postorder(list, n);
                }
            }

            list.add(root.val);
        }
    }
}
