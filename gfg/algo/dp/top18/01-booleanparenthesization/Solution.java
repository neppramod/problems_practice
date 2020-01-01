import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char symbols[] = "TTFT".toCharArray();
        char operators[] = "|&^".toCharArray();

        System.out.println(numberOfWays(symbols, operators));
        System.out.println(numberOfWays2(symbols, operators));

    }

    static int numberOfWays(char[] symbols, char[] operator)
    {
        int N = symbols.length;

        int T[][] = new int[N][N];
        int F[][] = new int[N][N];

        // fill up base case
        for (int i = 0; i < N; i++) {
            if (symbols[i] =='T') {
                T[i][i] = 1;
                F[i][i] = 0;
            } else {
                T[i][i] = 0;
                F[i][i] = 1;
            }
        }

        for (int gap = 1; gap < N; gap++) {
            for (int i = 0, j = gap; j < N; i++,j++) {
                T[i][j] = 0;
                for (int g = 0; g < gap; g++) {
                    int k = i+g;
                    int tik = T[i][k] + F[i][k];
                    int tkj = T[k+1][j] + F[k+1][j];

                    if (operator[k] == '&') {
                        T[i][j] += T[i][k] * T[k+1][j];
                        F[i][j] += (tik * tkj - T[i][k] * T[k+1][j]);
                    } else if (operator[k] == '|') {
                        T[i][j] += (tik*tkj-F[i][k] * F[k+1][j]);
                        F[i][j] += F[i][k] * F[k+1][j];
                    } else if (operator[k] == '^') {
                        T[i][j] += (T[i][k] * F[k+1][j] + F[i][k] * T[k+1][j]);
                        F[i][j] += (T[i][k] * T[k+1][j] + F[i][k] * F[k+1][j]);
                    }
                }
            }
        }

        return T[0][N-1];
    }

    static int numberOfWays2(char[] symbols, char[] operator)
    {
        int N = symbols.length;

        int T[][] = new int[N][N];
        int F[][] = new int[N][N];

        // fill up base case
        for (int i = 0; i < N; i++) {
            T[i][i] = symbols[i] == 'T' ? 1 : 0;
            F[i][i] = symbols[i] == 'F' ? 1 : 0;
        }

        for (int gap = 0; gap < N; gap++) {
            for (int i = 0, j = gap; j < N; i++,j++) {
x
                for (int k = i; k < j; k++) {
                    int tik = T[i][k] + F[i][k];
                    int tkj = T[k+1][j] + F[k+1][j];

                    if (operator[k] == '&') {
                        T[i][j] += T[i][k] * T[k+1][j];
                        F[i][j] += (tik * tkj - T[i][k] * T[k+1][j]);
                    } else if (operator[k] == '|') {
                        T[i][j] += (tik*tkj-F[i][k] * F[k+1][j]);
                        F[i][j] += F[i][k] * F[k+1][j];
                    } else if (operator[k] == '^') {
                        T[i][j] += (T[i][k] * F[k+1][j] + F[i][k] * T[k+1][j]);
                        F[i][j] += (T[i][k] * T[k+1][j] + F[i][k] * F[k+1][j]);
                    }
                }
            }
        }


        return T[0][N-1];
    }

}
