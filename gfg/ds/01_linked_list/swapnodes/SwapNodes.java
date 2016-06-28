/*
Swap nodes of a linked list, given two keys
Swap 2 and 9

5 -> 7 -> 9 -> 4 -> 8 -> 2 -> 10
5 -> 7 -> 2 -> 4 -> 8 -> 9 -> 10

Loop through the node and find prev and current of first node
Loop through the node and find prev and current of second node
Interchange next pointer of prev x and prev y to y and x respectively
Interchange next pointer of x and y to next of each other.

swap(node, 2, 9) -> prevx = 7, x = 9 : prevy = 8, y = 2.

7.next = 2
8.next = 9

9.next = 10
2.next = 4
*/

void swap(Node node, int a, int b)
{
    if (node == null || node.next == null)
        return;

    if (a == b)
        return;

    Node x = node;
    Node prevX = null;

// when x comes to current node, prevX is still pointing to previous node
    while (x.data != a) { // O(n)
        prevX = x;
        x = x.next;
    }

    while (y.data != b) { // O(n)
        prevY = y;
        y = y.next;
    }

// swap next pointer of prev
    prevX.next = y;
    prevY.next = x;

// Swap next pointer of x and y
    Node tmp = x.next;
    x.next = y.next;
    n.next = tmp;
}

