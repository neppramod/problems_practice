import java.io.*;
import java.util.*;

public class Solution
{
    static class Node
    {
        char data;

        public Node(char data)
        {
            this.data = data;
        }
        
        Node[] nodes = new Node[26];
        int count = 0;

        public String toString() { return "" + data;}
    }

    public static int find(Node head, String partial)
    {
        Node cur = head;

        for (int i = 0; i < partial.length(); i++) {            
            if (cur.nodes[partial.charAt(i)-'a'] == null) {
                return 0;
            } else {            
                cur = cur.nodes[partial.charAt(i)-'a'];
            }
        }


        int count = 0;
        for (int i = 0; i < cur.nodes.length; i++) {
            if (cur.nodes[i] != null) {
                count+=cur.nodes[i].count;
            }
        }

        return count;
    }

    public static void insert(Node head, String name)
    {
        insert(head, name.toCharArray(), 0);
    }

    private static void insert(Node cur, char[] name, int i)
    {        
        if (i == name.length) {
            return;
        } else {
            int index = name[i] - 'a';

            if (cur.nodes[name[i]-'a'] == null) {
                cur.nodes[name[i]-'a'] = new Node(name[i]);                
            }
            
            insert(cur.nodes[name[i]-'a'], name, i+1);
            cur.nodes[name[i]-'a'].count++;
        }
    }

    public static void main(String[] args)
    {
        Node head = new Node(' ');
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();       
        ArrayList<String> findTexts = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String command = sc.next();
            String text = sc.next();            
            
            if (command.equals("add")) {
                insert(head, text);
            } else if (command.equals("find")) {
                findTexts.add(text);
            }
        }

        for (String text : findTexts) {
            System.out.println(find(head, text));
        }       
       
    }
}
