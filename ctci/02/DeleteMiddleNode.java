public class DeleteMiddleNode
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

    public static void deleteMiddle(Node middleNode)
    {
        Node nextNode = middleNode.next;
        middleNode.data = nextNode.data;
        middleNode.next = nextNode.next;
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
        deleteMiddle(n7);
        print(n);

    }

}
