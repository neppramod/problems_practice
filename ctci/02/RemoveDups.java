public class RemoveDups
{
    static class Node
    {
        int data;
        Node next;

        Node(int d) { data = d; }
    }

    public static void removedups(Node node)
    {
        while (node != null) {
            Node cur = node;

            while (cur.next != null) {
                if (cur.next.data == node.data) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            
            node = node.next;
        }
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

        removedups(n);
        print(n);
        print(n);
    }
}
