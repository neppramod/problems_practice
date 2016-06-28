// A complete working Java program to delete a node in a linked list
// at a given position
class LinkedList
{
    Node head; // head of list

    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
           Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Given a reference (pointer to pointer) to the head of a list
       and a position, deletes the node at the given position */
    void deleteNode(int k)
    {
        if (head == null) {
            return;
        }

        if (k == 1) {
            head = head.next;
            return;
        }

        int count = 0;
        Node node = head;

        while (count < k - 1 && node != null) { // n
            node = node.next;
            count++;
        }

        if (node != null) {
            if (node.next == null) {
                node.next = null;
            } else {
                node.next = node.next.next;
            }
        }
    }


    /* This function prints contents of linked list starting from
       the given node */
    public void printList()
    {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }

    /* Drier program to test above functions. Ideally this function
       should be in a separate user class. It is kept here to keep
       code compact */
    public static void main(String[] args)
    {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();

        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
        llist.push(8);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();

        llist.deleteNode(4); // Delete node at position 4

        System.out.println("\nLinked List after Deletion at position 4: ");
        llist.printList();
        System.out.println();
        System.out.println("\nLinked List after Deletion at position 2: ");
        llist.deleteNode(2); // Delete node at position 2
        llist.printList();
    }
}
