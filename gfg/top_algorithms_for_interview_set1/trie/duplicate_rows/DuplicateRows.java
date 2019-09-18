import java.util.*;

public class DuplicateRows
{
    private static class Trie
    {
        Trie[] child = new Trie[2];
        boolean leaf = false;
    }

    private static boolean insert(int[] matrixRow, Trie root)
    {
        Trie cur = root;
        for (int i = 0; i < matrixRow.length; i++) {

            // Create new path, if it does not exist
            if (cur.child[matrixRow[i]] == null) {
                cur.child[matrixRow[i]] = new Trie();
            }

            cur = cur.child[matrixRow[i]];
        }

        // if row already exist return false
        if (cur.leaf) {
            return false;
        } else {
            // making leaf node true and return true
            cur.leaf = true;
            return cur.leaf;
        }
    }

    public static void printDuplicateRows(int[][] matrix)
    {
        Trie root = new Trie();

        // insert matrix into trie, while checking for duplicate
        for (int i = 0; i < matrix.length; i++) {

            // if already exist
            if (!insert(matrix[i], root)) {
                System.out.println("Duplicate row " + (i+1));
            }
        }
    }

    public static final void main(final String[] args) {
        int[][] mat =
            {
                {1, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0, 0},
                {1, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 1},
                {0, 0, 1, 0, 0, 1},
            };
        printDuplicateRows(mat);
    }

}
