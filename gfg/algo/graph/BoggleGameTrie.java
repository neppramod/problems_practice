import java.util.*;

public class BoggleGameTrie
{
    private final static int SIZE = 26;

    static class TrieNode
    {
        TrieNode child[] = new TrieNode[SIZE];
        boolean leaf;

        public TrieNode()
        {
            leaf = false;
            for (int i = 0; i < SIZE; i++) {
                child[i] = null;
            }
        }
    }

    static void insert(TrieNode root, String input)
    {
        TrieNode node = root;   // can't be null
        int n = input.length();

        for (int i = 0; i < n; i++) {
            int index = input.charAt(i) - 'A';  // only upper case
            if (node.child[index] == null) node.child[index] = new TrieNode();
            node = node.child[index];
        }

        node.leaf = true;
    }

    public static void main(String[] args)
    {
        char[][] boggle = {{'G','I','Z'},
                           {'U','E','K'},
                           {'Q','S','E'}};



        List<String> dictionary = Arrays.asList("GEEKS", "FOR", "QUIZ", "GO");
        TrieNode root = new TrieNode();
        for (String d : dictionary) {
            insert(root, d);
        }

        HashSet<String> set = new HashSet<>();

        findWord(boggle, root, set);

        for (String word : set) {
            System.out.println(word);
        }
    }



    static void findWord(char[][] matrix, TrieNode root, HashSet<String> set)
    {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        String prefix = "";
        TrieNode node = root;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.child[(matrix[i][j] - 'A')] != null) {
                    prefix = prefix + matrix[i][j];
                    solve(node.child[(matrix[i][j] - 'A')], set, visited, matrix, prefix, i, j);
                    prefix = "";
                }
            }
        }
    }

    static boolean isvalid(int i, int j, boolean[][] visited)
    {
        int m = visited.length;
        int n = visited[0].length;

        if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) return true;
        else return false;
    }

    static void solve(TrieNode root, HashSet<String> set, boolean[][] visited, char[][] matrix, String prefix, int x, int y)
    {
        int m = matrix.length, n = matrix[0].length;
        // if (x < 0 || x > m-1 || y < 0 || y > n-1) return;
        if (!isvalid(x, y, visited)) return;
        if (root == null) return;
        // if (visited[x][y]) return;

        String newString = prefix + matrix[x][y];
        if (root.leaf == true) set.add(newString);

        visited[x][y] = true;

        for (int i = 0; i < SIZE; i++) {
            if (root.child[i] != null) {
                char cur =(char)(i + 'A');
                for (int j = -1; j <= 1; j++) {
                    for (int k = -1; k <= 1; k++) {

                        if (isvalid(x+j, y+k, visited) && matrix[x+j][y+k] == cur)
                            solve(root.child[i], set, visited, matrix, newString, x+j, y+k);
                    }
                }
            }
        }

        visited[x][y] = false; // clear current search
    }
}
