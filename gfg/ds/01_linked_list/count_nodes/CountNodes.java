

// recursive
/* Returns count of nodes in linked list */
public int getCountRec(Node node)
{
    if (node == null)
        return 0;

    /*
    if (node.next == null)
    	return 1;
    */

    int total = 1 + getCountRec(node.next);
    return total;

}


// Iterative
/* Returns count of nodes in linked list */
public int getCount()
{

    int count = 0;
    Node node = head;

    while (node != null) {  // 9
        count++;                     // count=4
        node = node.next;
    }

    return count;
}
