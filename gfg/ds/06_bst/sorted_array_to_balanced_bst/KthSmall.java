import java.util.*;

public class KthSmall
{

    static class Node
    {
        Node left;
        Node right;
        int data;

        Node (int d)
        {
            data = d;
        }
    }

    static Node arrayToBST(int[] arr, int low, int high)
    {
        if (high < low)
            return null;

        if (arr == null || arr.length == 0)
            return null;

        int mid = low + (high-low)/2;
        Node node = new Node(arr[mid]);
        node.left = arrayToBST(arr, low, mid-1);
        node.right = arrayToBST(arr, mid+1, high);

        return node;
    }


    static void printBST(Node node)
    {
        if (node == null)
            return;

        // pre-order

        System.out.print(node.data + " ");

        printBST(node.left);
        printBST(node.right);
    }

    // print kthSmall
    static void kthSmall(Node node, int k, Queue<Integer> queue)
    {
        if (node == null)
            return;

        kthSmall(node.left, k-1, queue);
        queue.add(node.data);
        kthSmall(node.right, k-1, queue);
    }

    public static void main(String[] args)
    {
        int[] arr1 = {4, 8, 10, 12, 14, 20, 22};
        Node node1 = arrayToBST(arr1, 0, arr1.length-1);
        printBST(node1);
        System.out.println();

        Queue<Integer> queue = new LinkedList<>();

        kthSmall(node1, 5, queue);

        for (int i = 0; i < 4; i++)
            queue.poll();

        System.out.println("Kth: " + queue.poll());
    }
}
