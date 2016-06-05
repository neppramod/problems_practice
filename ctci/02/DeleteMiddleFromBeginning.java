public class DeleteMiddleFromBeginning
{
    static class Node
    {
        int data;
        Node next;

        Node(int d) { data = d; }
    }

    public static void print(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }

        System.out.println();
    }

    public static void deleteMiddle(Node node)
    {
        // currently not handling any corner case like second element or third
        if (node == null || node.next == null || node.next.next == null)
            return;

        Node front = node.next.next;
        Node back = node;
        while (front.next != null) {
            back = back.next;
            front = front.next.next;
        }

        back.next = back.next.next;
    }

    public static void main(String[] args)
    {
        Node n = new Node(5);
        n.next = new Node(5);
        Node n7 = new Node(7);
        n.next.next = n7;
        n.next.next.next = new Node(5);
        n.next.next.next.next = new Node(2);

        print(n);
        deleteMiddle(n);
        print(n);

    }

}
