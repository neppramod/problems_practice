import java.util.*;

public class Solution
{
    static final int MAXN = 100010;

    static void dfs1(int v, int p, long[] dp, long[] correction, LinkedList<Integer> [] graph, long M)
    {
        dp[v] = 1;
        List<Integer> children = new ArrayList<>();
        for (int u : graph[v]) {
            if (u == p) {
                continue;
            }

            dfs1(u, v, dp, correction, graph, M);
            dp[v] = (dp[v] * (1 + dp[u])) % M;
            children.add(u);
        }

        List<Long> prefixV = new ArrayList<>();
        List<Long> suffixV = new ArrayList<>();
        long prefix = 1, suffix = 1;

        for (int i = 0; i < children.size(); i++) {
            int u = children.get(i);
            prefixV.add(prefix);
            prefix = (prefix * (1 + dp[u])) % M;
        }

        for (int i = children.size() - 1; i >= 0; i--) {
            int u = children.get(i);
            suffixV.add(suffix);
            suffix = (suffix * (1 + dp[u])) % M;
        }

        Collections.reverse(suffixV);

        for (int i = 0; i < children.size(); i++) {
            int u = children.get(i);
            correction[u] = (prefixV.get(i) * suffixV.get(i)) % M;
        }
    }

    static void dfs2(int v, int p, long[] correction, int M, long[] answerP, LinkedList<Integer> [] graph, long[] dp)
    {
        answerP[v] = (dp[v] * correction[v]) % M;

        for (int u: graph[v]) {
            if (u == p) {
                continue;
            }

            correction[u] = ((correction[u] * correction[v]) + 1) % M;
            dfs2(u,v, correction, M, answerP, graph, dp);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();


        long[] correction = new long[MAXN];
        long[] answerP = new long[MAXN];
        long[] dp = new long[MAXN];
        LinkedList<Integer>[] graph = new LinkedList[MAXN];

        for (int i = 0; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 1; i < N; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].addLast(v);
            graph[v].addLast(u);
        }

        dfs1(1, -1, dp, correction, graph, M);
        correction[1] = 1;
        dfs2(1, -1, correction, M, answerP, graph, dp);

        for (int i = 1; i <= N; i++) {
            System.out.println(answerP[i]);
        }
    }

}
