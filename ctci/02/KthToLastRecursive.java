public class KthToLastRecursive
{
    static Node ktoLast(Node node, int k)
    {
        if (node == null)
            return null;
        
        if (node.next == null || k <= 0) {
            return node;
        } else {
            return ktoLast(node.next, k - 1);
        }
    }

    public static void main(String[] args)
    {
        Node n = Node.getNode();
        Node.print(n);
        Node kNode = ktoLast(n, 2);
        Node.print(kNode);

        Node n1 = null;
        Node kn1 = ktoLast(n1, 2);
        Node.print(kn1);
    }
}
