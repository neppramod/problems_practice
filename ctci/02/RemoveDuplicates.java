public class RemoveDuplicates
{
    static class Node
    {
        Node next;
        int data;
        Node(int d) { data = d; }
    }

    static void removeDuplicates(Node node)
    {
        Node current = node;

        if (current == null || current.next == null)
            return;

        while (current.next != null && current.data == current.next.data) {
            current.next = current.next.next;
        }

        while (current.next != null) {
            Node runner = current.next;

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                }
            }

            current = current.next;
        }
    }

    static void print(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
    }

    public static void main(String[] args)
    {
        Node n = new Node(5);
        n.next = new Node(5);
        n.next.next = new Node(5);
        n.next.next.next = new Node(2);

        removeDuplicates(n);
        print(n);
    }
}
