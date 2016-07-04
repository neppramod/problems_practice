import java.util.*;

public class MergeTwoBST
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

    static Node merge(Node node1, Node node2)
    {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        createList(node1, list1);
        createList(node2, list2);
        int[] arr = new int[list1.size() + list2.size()];
        merge(list1, list2, arr);
        return arrayToBST(arr, 0, arr.length-1);
    }

    static void createList(Node root, ArrayList<Integer> list)
    {
        if (root == null)
            return;

        createList(root.left, list);
        list.add(root.data);
        createList(root.right, list);
    }

    static void merge(ArrayList<Integer> list1, ArrayList<Integer> list2, int[] arr)
    {
        int i = 0;
        while (list1.size() > 0 && list2.size() > 0) {
            if (list1.get(0) < list2.get(0)) {
                arr[i++] = list1.remove(0);
            } else {
                arr[i++] = list2.remove(0);
            }
        }

        while(list1.size() != 0) {
            arr[i++] = list1.remove(0);
        }

        while(list2.size() != 0) {
            arr[i++] = list2.remove(0);
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


    public static void main(String[] args)
    {
        int[] arr1 = {1,3,  5,  7,  9};
        Node node1 = arrayToBST(arr1, 0, arr1.length-1);
        printBST(node1);
        System.out.println();

        int[] arr2 = {2,4,  6,  8,  15};
        Node node2 = arrayToBST(arr2, 0, arr2.length-1);
        
        printBST(node2);
        System.out.println();


        Node node = merge(node1, node2);

        printBST(node);
        System.out.println();
    }


}
