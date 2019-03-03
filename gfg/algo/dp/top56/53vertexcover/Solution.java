import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node root = createNode(20);
        root.left = createNode(8);
        root.left.left = createNode(4);
        root.left.right = createNode(12);
        root.left.right.left = createNode(10);
        root.left.right.right = createNode(14);
        root.right = createNode(22);
        root.right.right = createNode(25);

        System.out.println(getVC(root));
        System.out.println(getVCDP(root));
    }

    private static int getVC(Node root)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;

        int curInc = 0;
        curInc = 1 + getVC(root.left) + getVC(root.right);

        int curExc = 0;

        if (root.left != null) {
            curExc += 1 + getVC(root.left.left) + getVC(root.left.right);
        }

        if (root.right != null) {
            curExc += 1 + getVC(root.right.left) + getVC(root.right.right);
        }

        return Math.min(curInc, curExc);
    }

    private static int getVCDP(Node root)
    {
        if (root == null) return 0;

        if (root.vc != 0) return root.vc;

        if (root.left == null && root.right == null) return 0;

        int curInc = 0;
        curInc = 1 + getVCDP(root.left) + getVCDP(root.right);

        int curExc = 0;

        if (root.left != null) {
            curExc += 1 + getVCDP(root.left.left) + getVCDP(root.left.right);
        }

        if (root.right != null) {
            curExc += 1 + getVCDP(root.right.left) + getVCDP(root.right.right);
        }

        root.vc = Math.min(curInc, curExc);
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
