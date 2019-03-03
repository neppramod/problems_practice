import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char symbols[] = "TTFT".toCharArray();
        char operators[] = "|&^".toCharArray();
        int n = symbols.length;

        System.out.println(countParenth(symbols, operators, n));
    }

    static int countParenth(char symbols[], char operators[], int n)
    {
        int T[][] = new int[n][n];
        int F[][] = new int[n][n];

        // fill diagonal with 1 or 0 based on symbol
        for (int i = 0; i < n; i++) {
            T[i][i] = (symbols[i] == 'T' ? 1 : 0);
            F[i][i] = (symbols[i] == 'F' ? 1 : 0);
        }

        // fill T[i][i+1]... F[i][i+1]
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                T[i][j] = 0;
                F[i][j] = 0;

                for (int g = 0; g < gap; g++) {
                    int k = i + g;

                    char c = operators[k];
                    int tik = T[i][k] + F[i][k];
                    int tkj = T[k+1][j] + F[k+1][j];

                    if (c == '&') {
                        T[i][j] += T[i][k] * T[k+1][j];
                        F[i][j] += (tik * tkj - T[i][k] * T[k+1][j]);
                    } else if (c == '|') {
                        T[i][j] += (tik * tkj - F[i][k] * F[k+1][j]);
                        F[i][j] += F[i][k] * F[k+1][j];
                    } else if (c == '^') {
                        T[i][j] += (T[i][k] * F[k+1][j] + F[i][k] * T[k+1][j]);
                        F[i][j] += (T[i][k] * T[k+1][j] + F[i][k] * F[k+1][j]);
                    }
                }
            }
        }

        return T[0][n-1];
    }
}
