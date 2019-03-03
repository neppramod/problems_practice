import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Job> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();

            queue.add(new Job(s,e,v));
        }

        Object[] objects = queue.toArray();
        Job[] jobs = new Job[N];
        System.arraycopy(objects, 0, jobs, 0, N);

        //System.out.println(Arrays.toString(jobs));
        System.out.println(getDPSum(jobs, N));
        System.out.println(getSumRec(jobs, N));
    }

    private static int getSumRec(Job[] jobs, int N)
    {
        if (N==1) return jobs[N-1].value;

        // with cur value
        Job cur = jobs[N-1];
        int curValue = cur.value;
        int j = getPrevNonConflictingIndex(jobs, N);

        if (j >= 0)
            curValue += getSumRec(jobs, j+1);

        return Math.max(curValue, getSumRec(jobs, N-1));

    }

    private static int getDPSum(Job[] jobs, int N)
    {
        int[] table = new int[N];
        table[0] = jobs[0].value;

        for (int i = 1; i < N; i++) {
            int curValue = jobs[i].value;

            int j = getPrevNonConflictingIndex(jobs, i);
            if (j >= 0) curValue += table[j];

            table[i] = Math.max(table[i-1], curValue);
        }

        return table[N-1];
    }

    private static int getPrevNonConflictingIndex(Job[] jobs, int i)
    {
        Job cur = jobs[i-1];

        for (int j = i-1; j >= 0; j--) {
            if (jobs[j].end <= cur.start) return j;
        }

        return -1;
    }

    private static class Job implements Comparable
    {
        int start, end, value;
        public Job(int s, int e, int v) { start = s; end = e; value = v;}
        public int compareTo(Object o) { Job j = (Job) o; return end - j.end; }
        public boolean equals(Object o) { Job j = (Job) o; return j.start == start && j.end == end && j.value == value; }
        public String toString() { return start + " " + end + " " + value; }
    }
}
