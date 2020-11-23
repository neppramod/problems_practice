package linkedlist;

/**
 * Given two numbers saved in linked list in reverse order, calculate sum and save in linked list
 * Input: (2 ->4 ->3) + (5 ->6 ->4) Output: 7 ->0 ->8
 * 
 * If list are not stored in reverse order, reverse the lists first and use following algorithm
 */
public class AddTwoNumbers {
    public ListNode  addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode result = new ListNode(0);
       ListNode p = result;

       int carry = 0;
       int sum = 0;

       while (l1 != null || l2 != null) {
           
            sum = 0;
        
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;

            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            p = p.next;
       }

       return result.next;  // since result(0) is only placeholder
    }

    static class ListNode
    {
        int val;
        ListNode next;

        public ListNode(int v) {
            val = v;
        }
    }
}
