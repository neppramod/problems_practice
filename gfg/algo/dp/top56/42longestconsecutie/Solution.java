import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] mat = { {'a','c','d'},
                         { 'h','b','a'},
                         { 'i','g','f'}};

        System.out.println(getLen(mat, 'a'));
        System.out.println(getLen(mat, 'e'));
        System.out.println(getLen(mat, 'b'));
        System.out.println(getLen(mat, 'f'));

    }

    static int getLen(char[][] mat, char start)
    {
        int x = -1, y = -1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] == start) {
                    x = i; y = j;
                    break;
                }
            }
        }

        if (x != -1 && y != -1) {
            return getCount(start, x, y, mat, mat.length);
        } else {
            return 0;
        }
    }

    static int getCount(char start, int x, int y, char[][] mat, int N) {
        if (x < 0 || x >= N || y < 0 || y >= N) return 0;

        char next = start++;
        for(int j = x-1; j < x+2; j++) {
            for (int k = y-1; k < y+2; k++) {
                if (j >= 0 && j < N && k >= 0 && k < N) {
                    char charAtij = mat[j][k];

                    if (next == charAtij) {
                        return 1 + getCount(next, j, k, mat, N);
                    }
                }
            }
        }

        return 0;
    }
}


/*
  mat[][] ={{a, c, d}, {h, b, e}, {i, g, f}};
 */
