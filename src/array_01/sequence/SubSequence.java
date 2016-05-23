package array_01.sequence;

public class SubSequence {
    public static void main(String[] args) {
        System.out.println(isSubSequence(new int[]{9, 3, 1, 7, 5, 11}, new int[]{3, 7, 11}));
        System.out.println(isSubSequence(new int[]{6, 4, 9, 2, 8}, new int[]{4, 8, 9}));
    }

    /**
     * @param sequence A sequence array that is parent of subsequence
     * @param subquence A sequence that might possible be a sub-set of sequence
     * @return Returns true if subsequence is a sub-set of sequence
     */
    private static boolean isSubSequence(int[] sequence, int[] subquence)
    {
        int j = 0;

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == subquence[j]) {
                j++;
            }
        }

        return j == subquence.length;
    }
}
