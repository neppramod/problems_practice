import java.util.*;


public class Solution
{
    public static void main(String[] args)
    {
        HashSet<Integer> lengths = new HashSet<>();
        int larger = 3;
        int shorter = 2;
        int k = 5;
        HashSet<String> visited = new HashSet<>();

        getLengths(0, shorter, larger, k, lengths, visited);

        System.out.println(lengths);
    }

    static void getLengths(int total, int shorter, int larger, int k, HashSet<Integer> lengths, HashSet<String> visited)
    {
        if (k == 0) {
            lengths.add(total);
            return;
        }

        String key = k + " " + total;
        if (visited.contains(key)) return;

        getLengths(total + shorter, shorter, larger, k-1, lengths, visited);
        getLengths(total + larger, shorter, larger, k-1, lengths, visited);

        visited.add(key);
    }

    HashSet<Integer> allLengths(int k, int shorter, int longer)
    {
        HashSet<Integer> lengths = new HashSet<>();
        for (int nShorter = 0; nShorter <= k; nShorter++) {
            int nLonger = k - nShorter;
            int length = nShorter * shorter + nLonger * longer;
            lengths.add(length);
        }

        return lengths;
    }
}
