/*
  LRU: Implement ISBN utility, using LRU
  insert(int isbn, int cost)
  Map.Entry<Integer,Integer> find(int isbn)
  remove(int isbn)
*/
import java.util.*;
public class Solution
{
    final int CAPACITY = 5;
    Map<Integer,Integer> map = new LinkedHashMap<Integer, Integer>(CAPACITY, 1.0f, true) { // update on access
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > CAPACITY;
            }
        };

    void insert(int isbn, int cost)
        {
            map.put(isbn, cost);
        }

    int find(int isbn)
        {
            if (!map.containsKey(isbn)) return -1;
            else return map.get(isbn);
        }

    void remove(int isbn)
        {
            map.remove(isbn);
        }

    void print()
        {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue() + ", ");
            }
        }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.insert(23, 50);
        solution.insert(25, 50);
        solution.insert(35, 57);
        solution.insert(22, 54);
        solution.insert(19, 34);
        solution.insert(4, 65);
        solution.print();
    }
}
