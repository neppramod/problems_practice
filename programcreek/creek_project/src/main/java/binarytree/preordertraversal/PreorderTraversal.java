package binarytree.preordertraversal;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preOrederTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        preOrederTraversal(root, list);

        return list;
    }

    private void preOrederTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        } else {
            list.add(root.val);
            preOrederTraversal(root.left, list);
            preOrederTraversal(root.right, list);
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
