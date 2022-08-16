import java.util.*;

// From left to right
public class PrintAllLeafNodes {
    public static void main(String[] args) {
	    PrintAllLeafNodes sol = new PrintAllLeafNodes();
        Tree r = c(1);
        r.left = c(2);
        r.left.left = c(4);
        r.right = c(3);
        r.right.left = c(5);
        r.right.left.left = c(6);
        r.right.left.right = c(7);
        r.right.right = c(8);
        r.right.right.left = c(9);
        r.right.right.right = c(10);
        printLeaf(r);
	}

    static void printLeaf(Tree r) {
        if (r == null) {
            return;
        } else if (r.left == null && r.right == null) {
            System.out.printf(r.val + " ");
        } else {
            printLeaf(r.left);
            printLeaf(r.right);
        }
    }

    static Tree c(int v) {
        return new Tree(v);
    }

    static class Tree {
        Tree left, right;
        int val;

        public Tree(int v) {
            val = v;
        }
    }
}
