import java.util.*;

public class BoggleTrie
{
    private static final int SIZE = 26;

    static class TrieNode
    {
        TrieNode[] child = new TrieNode[SIZE];
        boolean leaf = false;
    }

    void insert(TrieNode root, String str)
    {
        TrieNode node = root;  // cannot be null, called from main
        int N = str.length();

        for (int i = 0; i < N; i++) {
            int curIndex = str.charAt(i) - 'A';
            if (node.child[curIndex] == null) {
                node.child[curIndex] = new TrieNode();
            }

            node = node.child[curIndex];
        }

        node.leaf = true;
    }

    void find(char[][] boggle, TrieNode root, HashSet<String> set)
    {
        int M = boggle.length;
        int N = boggle[0].length;

        boolean[][] visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                TrieNode node = root.child[boggle[i][j] - 'A'];
                if (node != null) {
                    search(boggle, node, set, visited, i, j, String.valueOf(boggle[i][j]));
                }
            }
        }
    }

    void search(char[][] boggle, TrieNode root, HashSet<String> set, boolean[][] visited, int x, int y, String str)
    {
        if (root == null || !isValid(x, y, visited)) return;
        if (root.leaf) {
            set.add(str);
        }

        visited[x][y] = true;

        for (int i = 0; i < SIZE; i++) {
            if (root.child[i] != null) {
                char ch = (char) (i + 'A');
                for (int j = -1; j <= 1; j++) {
                    for (int k = -1; k <= 1; k++) {
                        if (isValid(x+j, y+k, visited) && boggle[x+j][y+k] == ch) {
                            search(boggle, root.child[i], set, visited, x+j, y+k, str + ch);
                        }
                    }
                }
            }
        }

        visited[x][y] = false;
    }

    boolean isValid(int i, int j, boolean[][] visited)
    {
        int M = visited.length;
        int N = visited[0].length;

        return (i >= 0 && i < M && j >= 0 && j < N && !visited[i][j]);
    }

    public static void main(String[] args)
    {
        char[][] boggle = {{'G','I','Z'},
                           {'U','E','K'},
                           {'Q','S','E'}};



        List<String> dictionary = Arrays.asList("GEE", "GEEKS", "FOR", "QUIZ", "GO");
        TrieNode root = new TrieNode();
        BoggleTrie boggleTrie = new BoggleTrie();
        for (String d : dictionary) {
            boggleTrie.insert(root, d);
        }

        HashSet<String> set = new HashSet<>();
        boggleTrie.find(boggle, root, set);

        System.out.println(set);
    }
}
