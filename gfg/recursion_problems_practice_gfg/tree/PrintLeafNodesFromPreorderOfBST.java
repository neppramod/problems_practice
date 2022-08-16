import java.util.*;

public class PrintLeafNodesFromPreorderOfBST {
	
    static int i = 0;
    static void printLeaves(int[] pre, int n) {
        isLeaf(pre, n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isLeaf(int[] pre, int n, int min, int max) {
        if (i >= n) {
            return false;
        }

        if (pre[i] >= min && pre[i] <= max) {
            i++;
            boolean left = isLeaf(pre, n, min, pre[i-1]);
            boolean right = isLeaf(pre, n, pre[i-1], max);
            
            if (!left && !right) {
                System.out.printf(pre[i-1] + " ");
            }
            
            return true;
            
        } else {
            return false;
        }
        
    }
    
    // Driver code
    public static void main(String[] args)
    {
        int preorder[] = {890, 325, 290, 530, 965};
        int n = preorder.length;
        printLeaves(preorder, n);
    }
}
