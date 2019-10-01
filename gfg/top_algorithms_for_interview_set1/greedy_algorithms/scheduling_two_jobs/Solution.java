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

    static boolean checkJobs(int[] starting, int[] ending, int n)
    {
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(starting[i], ending[i]);
        }

        Arrays.sort(pairs);

        int tv1 = pairs[0].second;
        int tv2 = pairs[1].second;

        for (int i = 2; i < n; i++) {
            // Check if starting time of next new job is greater than ending
            // time of current job
            if (pairs[i].first >= tv1) {
                tv2 = tv1;
                tv1 = pairs[i].second;
            }
            // Check if starting time of next new job is greater than ending
            // time of current job
            else if (pairs[i].first >= tv2) {
                tv2 = pairs[i].second;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        int startin[] = { 1, 2, 4 }; // starting time of jobs
        int endin[] = { 2, 3, 5 }; // ending times of jobs

        int n = startin.length;
        System.out.println(checkJobs(startin, endin, n));
    }
}
