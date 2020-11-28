package binarytree.verticalordertraversal;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalorderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();
        verticalOrder(root, map, 0);

        for (int k : map.keySet()) {
            list.add(map.get(k));
        }

        return list;
    }

    private void verticalOrder(TreeNode root, Map<Integer, List<Integer>> map, int level) {
        if (root == null) {
            return;
        }

        if (map.containsKey(level)) {
            map.get(level).add(root.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(level, list);
        }

        verticalOrder(root.left, map, level - 1);
        verticalOrder(root.right, map, level + 1);
    }
}
