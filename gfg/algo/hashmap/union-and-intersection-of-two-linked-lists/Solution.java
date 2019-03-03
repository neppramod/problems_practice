import java.util.*;

// LinkedList
public class Solution
{
    Node head;
    class Node {
        int data;
        Node next;

        Node(int d) { data = d; next = null;}
    }

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    Solution intersection(Node llist1, Node llist2) {
        Solution result = new Solution();
        HashSet<Integer> hset = new HashSet<>();
        while (llist1 != null) {
            hset.add(llist1.data);
            llist1 = llist1.next;
        }

        while (llist2 != null) {
            if (hset.contains(llist2.data)) {
                result.push(llist2.data);
            }
            llist2 = llist2.next;
        }

        return result;
    }

    Solution union(Node llist1, Node llist2) {
        Solution result = new Solution();
        HashSet<Integer> hset = new HashSet<>();

        while (llist1 != null) {
            hset.add(llist1.data);
            llist1 = llist1.next;
        }

        while (llist2 != null) {
            hset.add(llist2.data);
            llist2 = llist2.next;
        }

        for (Integer item : hset) {
            result.push(item);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Solution llist1 = new Solution();
        Solution llist2 = new Solution();

        llist1.push(20);
        llist1.push(4);
        llist1.push(15);
        llist1.push(10);

        llist2.push(10);
        llist2.push(2);
        llist2.push(4);
        llist2.push(8);

        Solution intersection = new Solution();
        Solution union = new Solution();

        intersection = intersection.intersection(llist1.head, llist2.head);
        union = union.union(llist1.head, llist2.head);

        intersection.printList();
        union.printList();

    }
}
