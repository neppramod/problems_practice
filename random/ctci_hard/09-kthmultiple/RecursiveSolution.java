import java.util.*;

/*
  Find the smallest kth multiple of 3,5 and 7

  Simplest is to find all multiples of 3,5,7 upto k in a list, sort and return kth number
 */
public class RecursiveSolution
{
    public static void main(String[] args)
    {
        System.out.println(kThMultiple(50000));
    }

    static int kThMultiple(int k)
    {
        if (k == 0) return 0;
        PriorityQueue queue = new PriorityQueue();
        queue.add(1);
        int x = 1;
        while (k > 0) {
            x = (int)queue.poll();
            k--;
            queue.add(x * 3);
            queue.add(x * 5);
            queue.add(x * 7);
        }

        return x;
    }

    static void handleAllMultiples()
    {
        int k = 10;
        ArrayList<Integer> allkMultiples = allKMultiples(3);
        Collections.sort(allkMultiples);
        System.out.println("Size: " + allkMultiples.size());
        System.out.println("Value: " + allkMultiples.get(k));
    }

    // O(n^3)
    static ArrayList<Integer> allKMultiples(int k)
    {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l <= k; l++) {
                    int result = (int) (Math.pow(3, i) * Math.pow(5, j) * Math.pow(7, k));
                    numbers.add(result);
                }
            }
        }

        return numbers;
    }
}
