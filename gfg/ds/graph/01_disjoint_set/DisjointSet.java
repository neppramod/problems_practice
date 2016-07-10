import java.util.*;

public class DisjointSet
{
    HashMap<Character, Character> parent;

    public DisjointSet(char[] arr)
    {
        parent = new HashMap<>();
        
        for (char c : arr) {
            parent.put(c, c);
        }
    }

    public char find(char item)
    {
        char parentItem = parent.get(item);
        if (parentItem == item)
            return item;
        else
            return find(parentItem);
    }

    public void union(char set1, char set2)
    {
        parent.put(set1, set2);
    }

    public void printsets()
    {
        for (char k : parent.keySet())
            System.out.println("Key: " + k + ", Value: " + parent.get(k));
    }

    public static void main(String[] args)
    {
        char[] arr = {'a','b','c','d','e','f'};
        DisjointSet ds = new DisjointSet(arr);

        ds.printsets();
        
        ds.union('a','b');
        ds.union('b','c');
        ds.union('c','d');
        ds.union('e','f');
        ds.union('e','a');

        ds.printsets();

        System.out.println();
        System.out.println(ds.find('a'));
        System.out.println(ds.find('d'));
    }
}
