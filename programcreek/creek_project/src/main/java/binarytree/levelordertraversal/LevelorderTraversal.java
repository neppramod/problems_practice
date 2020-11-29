package binarytree.levelordertraversal;

import binarytree.TreeNode;

import java.util.*;

public class LevelorderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        // For reverse you can use Collections.reverseOrder in below constructor
        // No change in runtime
        // Or reverse the list after return (O(n))
        // Also can you 2 queue to track current and next, switch at end of handling current
        // Or use count for each level
        Map<Integer, List<Integer>> map = new TreeMap<>();
        levelOrder(root, map, 0);

        for (int k : map.keySet()) {
            list.add(map.get(k));
        }

        return list;
    }

    void levelOrder(TreeNode root, Map<Integer, List<Integer>> map, int height) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(height)) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(height, list);
        } else {
            map.get(height).add(root.val);
        }

        levelOrder(root.left, map, height + 1);
        levelOrder(root.right, map, height + 1);
    }
}
