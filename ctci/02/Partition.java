public class Partition
{
    static class Node
    {
        int data;
        Node next;

        Node(int d) { data = d; }
    }

    static void parition(Node node, int p)
    {
        Node i = node;
        Node j = node;

        while (j != null) {
            if (j.data < p) {
                int tmp = i.data;
                i.data = j.data;
                j.data = tmp;
                i = i.next;
            }
            j = j.next;
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
        Node n = new Node(3);
        n.next = new Node(5);
        n.next.next = new Node(8);
        n.next.next.next = new Node(5);
        n.next.next.next.next = new Node(10);
        n.next.next.next.next.next = new Node(2);
        n.next.next.next.next.next.next = new Node(1);

        parition(n, 5);
        print(n);
    }

}
