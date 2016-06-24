import java.util.*;

public class DepthInOneLine
{
    static class Node
    {
        Node left;
        Node right;
        int data;
        int level;
        public Node(int d, int l) { data = d; level = l; }
    }

    static void printNode(Node node)
    {
        if (node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int currentLevel = -1;
        
        while (!queue.isEmpty()) {            
            Node n = queue.poll();
            if (n.level != currentLevel) {
                System.out.println();
                currentLevel++;
            }

            System.out.print(n.data + " ");

            if (n.left != null) {
                queue.add(n.left);
            }
            
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

    public static void main(String[] args)
    {
        Node n = new Node(1,0);
        n.left = new Node(2,1);
        n.right = new Node(3,1);
        n.left.left = new Node(4, 2);
        n.left.right = new Node(5, 2);
        n.left.left.right = new Node(7, 3);
        printNode(n);
    }
}
