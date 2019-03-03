import java.util.*;

public class MinVCSum
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        Node root = createNode(20);
        root.left = createNode(8);
        root.left.left = createNode(4);
        root.left.right = createNode(52);
        root.left.right.left = createNode(10);
        root.left.right.right = createNode(14);
        root.right = createNode(22);
        root.right.right = createNode(25);

        int vcSum = vc(root);
        System.out.println(vcSum);
    }

    static int vc(Node root)
    {
        if (root == null) return 0;

        if (root.vc != 0) return root.vc;

        if (root.left == null && root.right == null) return 0;

        // rootinc
        int rootIncSum = root.data + vc(root.left) + vc(root.right);
        int rootExcSum = 0;

        if (root.left != null) {
            rootExcSum += root.left.data + vc(root.left.left) + vc(root.left.right);
        }

        if (root.right != null) {
            rootExcSum += root.right.data + vc(root.right.left) + vc(root.right.right);
        }

        root.vc = Math.min(rootIncSum, rootExcSum);

        return root.vc;

    }

    private static Node createNode(int d) {
        Node n = new Node(d);
        return n;
    }

    // Tree Node
    private static class Node
    {
        int data;
        int vc;
        public Node(int d) { data = d; vc = 0;}
        Node left, right;
    }
}
