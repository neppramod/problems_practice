import java.util.*;

public class Solution
{
    static class Node
    {
        char data;
        boolean done;
        public Node(char d) {data = d;}
        Node[] nodes = new Node[10];
    }
    
    private static boolean insertUnique(Node head, String str)
    {
        if (str.length() == 0)
            return true;
        else
            return insertUnique(head, str, 0);
    }

    private static boolean insertUnique(Node head, String str, int i)
    {
        if (i == str.length()) {
            return true;
        } else {
            Node curCharNode = head.nodes[str.charAt(i)-'a'];
            if (curCharNode == null) {
                head.nodes[str.charAt(i) - 'a'] = new Node(str.charAt(i));
                curCharNode = head.nodes[str.charAt(i)-'a'];
            }
            if (curCharNode.done == true) {
                return false;
            }

            if (i == str.length() - 1) {
                curCharNode.done = true;

                //System.out.println("Setting done at " + curCharNode.data);
            }

            return insertUnique(curCharNode, str, i+1);            
          
        }       
    }
    
    public static void main(String[] args)
    {
        Node head = new Node(' ');
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            if (!insertUnique(head, input)) {
                System.out.println("BAD SET");
                System.out.println(input);
                return;
            }
        }

        System.out.println("GOOD SET");
    }
}
