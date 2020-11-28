package binarytree;

public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }

    public static TreeNode c(int v) {
        return new TreeNode(v);
    }
}
