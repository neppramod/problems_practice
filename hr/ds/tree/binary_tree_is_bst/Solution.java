import java.util.*;

public class Tree {
    // List of node data values:
    Vector<Integer> values;
    // Total number of nodes in the tree:
    private int count;

    Tree() {
        this.values = new Vector<Integer>();
        this.count = 0;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node() {
            this.data = -1;
            this.left = null;
            this.right = null;
        }
    }

    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
    */
    boolean checkBST(Node root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        if (root.left != null && root.left.data > root.data)
            return false;

        if (root.right != null && root.right.data < root.data)
            return false;

        boolean left = checkBST(root.left);
        if (!left)
            return false;

        return checkBST(root.right);
    }

    void inOrder (Node root, int levels) {

        if(root != null) {
            // If there are still unfilled levels, fill left subtree:
            if (levels > 0) {
                // Create a new left child node:
                root.left = new Node();
                inOrder(root.left, levels - 1);
            }

            // Set node data:
            root.data = values.elementAt(count);
            count++;

            // If there are still unfilled levels, fill right subtree:
            if (levels > 0) {
                // Create a new right child node:
                root.right = new Node();
                inOrder(root.right, levels - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int height = scanner.nextInt();

        // Read data values for tree's nodes:
        Tree tree = new Tree();
        while(scanner.hasNext()) {
            tree.values.add(scanner.nextInt());
        }
        scanner.close();

        // Fill tree:
        Node root = new Node();
        tree.inOrder(root, height);

        // Print result:
        System.out.println( (tree.checkBST(root) == true) ? "Yes" : "No" );

    }
}
