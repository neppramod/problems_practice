import java.util.*;

public class BoggleGame
{
    public static void main(String[] args)
    {
        char[][] boggle = {{'G','I','Z'},
                           {'U','E','K'},
                           {'Q','S','E'}};

        List<String> dictionary = Arrays.asList("GEEKS", "FOR", "QUIZ", "GO");

        HashSet<String> set = new HashSet<>();

        findWord(boggle, dictionary, set);

        for (String word : set) {
            System.out.println(word);
        }
    }


    static void findWord(char[][] boggle, List<String> dictionary, HashSet<String> set)
    {
        int m = boggle.length;
        int n = boggle[0].length;
        boolean[][] visited = new boolean[m][n];
        String prefix = "";

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWord(boggle, dictionary, set, visited, prefix, i, j);
            }
        }
    }

    static void findWord(char[][] boggle, List<String> dictionary, HashSet<String> set, boolean[][] visited, String prefix, int x, int y)
    {
        int m = boggle.length;
        int n = boggle[0].length;

        if (x < 0 || y < 0 || x > m - 1 || y > n - 1) return;
        if (visited[x][y]) return;

        visited[x][y] = true;

        String newString = prefix + boggle[x][y];
        if (dictionary.contains(newString)) set.add(newString);

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                findWord(boggle, dictionary, set, visited, newString, x + i, y + j);
            }
        }

        visited[x][y] = false;

    }
}
