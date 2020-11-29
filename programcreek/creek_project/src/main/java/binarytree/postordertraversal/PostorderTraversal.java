package binarytree.postordertraversal;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

    List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        } else {
            postorderTraversal(root.left, list);
            postorderTraversal(root.right, list);

            list.add(root.val);
        }
    }


}
