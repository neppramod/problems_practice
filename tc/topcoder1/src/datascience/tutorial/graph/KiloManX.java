import java.util.*;

// Dijakstra
public class KiloManX
{
    static class Node implements Comparable
    {
        int shots;
        int weapons;

        public Node(int w, int s) { weapons = w; shots = s; }

        public int compareTo(Object o)
        {
            Node n = (Node)o;
            return n.shots - shots;
        }
    }

    boolean[] visited = new boolean[32456];

    public int minShots(String[] damageChart, int[] bossHealth)
    {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        int noOfWeapons = damageChart.length;

        while (!pq.isEmpty()) {
            Node top = pq.poll();

            if (visited[top.weapons]) continue;
            visited[top.weapons] = true;

            // if all boses defeated, return shots (2^n - 1). 3 noOfWeapons = 111 = 7
            if (((1 << noOfWeapons) - 1) == top.weapons) return top.shots;

            for (int i = 0; i < damageChart.length; i++) {

                // if this boss has already been visited
                if (((top.weapons >> i) & 1) > 0) continue;

                int best = bossHealth[i];

                for (int j = 0; j < damageChart[i].length(); j++) {

                    // if same boss
                    if (i == j) continue;
                    int damageChartValue = Integer.parseInt(damageChart[i].charAt(j) + "");

                    if (((top.weapons >> j) != 0) && damageChartValue != 0) {
                        int noOfShots = bossHealth[i] / damageChartValue;
                        if ((bossHealth[i] % damageChartValue) > 0)
                            noOfShots++;
                        best = Math.min(best, noOfShots);
                    }
                }

                pq.add(new Node((1 << i)|top.weapons, top.shots + best));
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        KiloManX kx = new KiloManX();
        System.out.println(kx.minShots(new String[] {"070","500","140"}, new int[] {150,150,150}));
    }
}
