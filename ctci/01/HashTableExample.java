public class HashTableExample
{
    // Linked list to create hashtable
    static class Node
    {
        Node next;
        String key;
        String value;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    
    static class HashTable
    {
        // HashTable of only 4 array
        Node[] array = new Node[4];

        void add(String key, String value)
        {
            int node = hash(key) % array.length;

            System.out.println("Adding " + value + " to index : " + node);
            
            if (array[node] == null) {
                array[node] = new Node(key, value);
            } else {
                Node cur = array[node];
                while(cur.next != null) {
                    cur = cur.next;
                }

                cur.next = new Node(key, value);
            }
        }
        
        String get(String key)
        {
            int index = hash(key) % array.length;
            Node cur = array[index];
            while (cur != null) {
                if (cur.key.equals(key)) {
                    return cur.value;
                }
                cur = cur.next;
            }

            return null;
        }

        private int hash(String str)
        {
            return Math.abs(str.hashCode());
        }
    }

    public static void main(String[] args)
    {
        HashTable ht = new HashTable();
        ht.add("one", "apple");
        ht.add("two", "orange");
        ht.add("three", "grapes");
        ht.add("four", "berries");
        
        System.out.println(ht.get("one"));
        System.out.println(ht.get("four"));
        System.out.println(ht.get("boguskey"));
    }
}
