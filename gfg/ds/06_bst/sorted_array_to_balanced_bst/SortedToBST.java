public class SortedToBST
{
    static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int d) { data = d; }
    }

    static Node createBST(int[] arr, int low, int high)
    {
        if (high < low)
            return null;

        int mid = low + (high-low)/2;
        Node node = new Node(arr[mid]);
        node.left = createBST(arr, low, mid-1);
        node.right = createBST(arr, mid+1, high);

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

    public static void main(String[] args)
    {
        int[] arr = {1,2,3, 4, 5, 6, 7, 8, 9};
        Node node = createBST(arr, 0, arr.length-1);
        printBST(node);
    }
}
