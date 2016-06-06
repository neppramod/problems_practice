/**
 * Sum Lists
 * 
 */

public class SumLists
{
    static Node sum(Node a, Node b)
    {
        int carry = 0;
        Node n = new Node();
        Node head = n;

        while (a != null || b != null) {
            int sum = 0;

            if (a != null) {
                sum += a.data;
            }

            if (b != null) {
                sum += b.data;
            }

            sum += carry;

            n.data = sum % 10;            
            carry = sum / 10;

            if ((a.next != null) || (b.next != null)) {
                n.next = new Node();
            } else {
                if (carry > 0) {
                    n.next = new Node(carry);
                }   else {
                    n.next = null;
                }
            }
            n = n.next;
            a = a.next;
            b = b.next;
        }

        return head;
    }

    public static void main(String[] args)
    {        
        Node n1 = Node.getNode();
        Node.print(n1);
        Node n2 = Node.getNode();
        Node.print(n2);
        Node n3 = sum(n1,n2);
        Node.print(n3);
    }
}
