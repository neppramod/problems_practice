import java.util.*;

public class BottomView
{
    static class Node
    {
        Node left, right;
        int data;
        int hd;  // horizontal distance

        public Node(int data) { this.data = data; }
    }

    public void bottomView(Node root)
    {
        if (root == null) return;
        int hd = 0;
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        root.hd = hd;
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            hd = node.hd;

            // update or add new
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            if (node.left != null) {
                node.left.hd = hd - 1;
                queue.add(node.left);
            }

            if (node.right != null) {
                node.right.hd = hd + 1;
                queue.add(node.right);
            }
        }

        System.out.println(map.values());
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        BottomView bottomView = new BottomView();
        bottomView.bottomView(root);
    }
}
