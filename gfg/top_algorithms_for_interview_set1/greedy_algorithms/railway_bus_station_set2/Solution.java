import java.util.*;

public class Solution
{
    static class Pair implements Comparable<Pair>
    {
        int first;
        int second;

        public Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }

        public boolean equals(Object o)
        {
            Pair p = (Pair)o;
            return first == p.first && second == p.second;
        }

        public int hashCode()
        {
            return Objects.hash(first, second);
        }

        public int compareTo(Pair p)
        {
            return first - p.first;   // only sort by key
        }
    }

    static int findPlatform(int[] arr, int[] dep, int n)
    {
        TreeSet<Pair> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(new Pair(arr[i], 'a'));
            set.add(new Pair(dep[i], 'd'));
        }

        int result = 0;
        int plat_needed = 0;

        for (Pair p : set) {
            if (p.second == 'a') {
                plat_needed++;
            } else {
                plat_needed--;
            }

            if (plat_needed > result) {
                result = plat_needed;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

        //int arr[] = { 100, 200, 300, 500, 400 };
        //int dep[] = { 600, 700,800, 600, 500 };

        int n = arr.length;
        System.out.println("Minimum Number of Platforms Requred = " + findPlatform(arr, dep, n));
    }
}
