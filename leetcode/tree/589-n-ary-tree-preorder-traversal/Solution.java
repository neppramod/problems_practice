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

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(list, root);
        return list;
    }

    static void preorder(List<Integer> list, Node root) {
        if (root == null) {
            return;
        } else {
            list.add(root.val);
            if (root.children != null) {
                for (Node n : root.children) {
                    preorder(list, n);
                }
            }
        }
    }
}
