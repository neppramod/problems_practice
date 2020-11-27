package linkedlist.deletenodeinlinkedlist;

public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int v) {
            val = v;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
