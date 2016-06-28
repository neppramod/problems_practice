/*
 Merge Sort Linked List

[8] -> [5] -> [7] -> [3]

We have to do a merge sort of this linked list

MergeSort(Node node)

If it is sorted return the node. A node with 1 element is already sorted
Get the mid point
Sort the first half
Sort the second half
Merge both half
*/

Node MergeSort(Node head)
{
    if (head == null || head.next == null)
        return head;

    Node headr = head;
    Node mid = getMid(head);
    Node secondPart = mid.next;
    mid.next = null;

    Node a = MergeSort(head);
    Node b = MergeSort(secondPart);

    headr = MergeSorted(a, b);
    return headr;
}

Node getMid(Node head)
{
    Node slow = head, fast = head;

    while (fast.next != null || fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}

Node MergeSorted(Node a, Node b)
{
    if (a == null)
        return b;

    if (b == null)
        return a;

    Node result = null;

    if (a.data < b.data) {
        result = a;
        result.next = MergeSorted(a.next, b);
    } else {
        result = b;
        result.next = MergeSorted(a, b.next);
    }

    return result;
}


