public class KthToLast
{
    static class Node
    {
        int data;
        Node next;

        Node(int d) { data = d; }
    }

    public static Node kthToLast(Node node, int k)
    {
        Node back = node;
        Node front = node;

        // some error checking on front and back
        int kcount = 0;
        while(front.next != null && kcount < k) {
            kcount++;
            front = front.next;
        }

        while (front.next != null) {
            back = back.next;
            front = front.next;
        }

        return back;
    }

    public static void print(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }

        System.out.println();
    }

        public static void main(String[] args)
    {
        Node n = new Node(5);
        n.next = new Node(5);
        n.next.next = new Node(7);
        n.next.next.next = new Node(5);
        n.next.next.next.next = new Node(2);

        Node node = kthToLast(n, 3);
        System.out.println(node.data);
    }

}
