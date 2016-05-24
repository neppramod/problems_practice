class CreateBSTFromSortedArray
{
    static class Node {
	Node left;
	Node right;
	int data;
    }

    static Node createBST(int left, int right, int[] array)
    {
	if (left > right) {
	    return null;
	}

	int mid = (left + right) / 2;
	Node node = new Node();
	node.data = array[mid];
	node.left = createBST(left, mid - 1, array);
	node.right = createBST(mid + 1, right, array);

	return node;
    }

    public static void print(Node node)
    {
	if (node == null) {
	    return;
	}


	// LVR
	System.out.print(node.data + " -> ");
	print(node.left);
	print(node.right);
    }

    public static void main(String[] args)
    {	
	int[] array = {1,2,3,4,5,6,7};
	CreateBSTFromSortedArray.Node node = createBST(0, array.length - 1, array);
	print(node);
    }
}
