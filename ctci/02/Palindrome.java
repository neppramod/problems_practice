import java.util.*;

public class Palindrome
{

    
    static boolean isPalindrome(Node node)
    {
        HashSet<Integer> set = new HashSet<>();

        while (node != null) {
            if (set.contains(node.data)) {
                set.remove(node.data);
            } else {
                set.add(node.data);
            }

            node = node.next;
        }

        return set.size () == 0 || set.size() == 1;
    }

    public static void main(String[] args)
    {
        Node n = new Node(3);
        n.next = new Node(7);
        n.next.next = new Node(8);
        n.next.next.next = new Node(7);
        n.next.next.next.next = new Node(3);

        Node.print(n);
        System.out.println(isPalindrome(n));
        
    }
}
