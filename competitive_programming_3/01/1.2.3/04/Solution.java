/*

04 - Given n random integers, print the distinct (unique) integers in sorted order

Answer (Random): [1, 5, 19, 44, 45, 60, 63, 84, 92, 93]
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        final int N = 10;
        Integer[] randomIntegers = new Integer[N];
        Random r = new Random();

        for (int i = 0; i < N; i++) {
            randomIntegers[i] = r.nextInt(100);
        }

        SortedSet<Integer> sortedSet = new TreeSet<>(Arrays.asList(randomIntegers));
        System.out.println(sortedSet);
    }
}
