import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode r = c(3);
        r.left = c(5);
        r.left.left = c(6);
        r.left.right = c(2);
        r.left.right.left = c(7);
        r.left.right.right = c(4);
        r.right = c(1);
        r.right.left = c(9);
        r.right.right = c(8);

        List<Integer> list = rightSideView(r);
        System.out.println(list);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        rightSideView(root, 0, map);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            list.add(map.get(i));
        }

        return list;
    }

    private static void rightSideView(TreeNode root, int lvl, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        } else {
            map.put(lvl, root.val);
            rightSideView(root.left, lvl+1, map);
            rightSideView(root.right, lvl+1, map);
        }
    }


    private static void printTree(TreeNode node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.val + " ");
            printTree(node.left);
            printTree(node.right);
        }
    }



    static TreeNode c(int val) {
        return new TreeNode(val);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
