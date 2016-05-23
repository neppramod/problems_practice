package linked_list;

import java.util.Scanner;

public class LinkedListExample {
    public void add(String data, Node node)
    {
        Node currentNode = node;


        while (currentNode.next != null) {
            currentNode = node.next;
        }


        currentNode = new Node();
        currentNode.data = data;
    }

    public void print(Node node)
    {
        if (node == null)
            return;
        System.out.println(node.data);
        print(node.next);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node node = new Node();

        String line = sc.nextLine();
        String[] words = line.split(" ");
        LinkedListExample linkedListExample = new LinkedListExample();

        for (int i = 0; i < words.length; i++) {
            linkedListExample.add(words[i], node);
        }
        linkedListExample.print(node);
    }
}
