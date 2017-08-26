import java.util.*;

public class KiloManX
{
    public static class Node implements Comparable
    {
        int shots;
        int weapons;
        public Node(int w, int s) { weapons = w; shots = s; }
        public int compareTo(Object o)
        {
            Node n = (Node) o;
            return n.shots - shots;
        }
    }

    boolean[] visited = new boolean[32569];

    public int leastShots(String[] damageChart, int[] bossHealth)
    {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node start = new Node(0, 0);
        pq.add(start);
        int noOfWeapons = damageChart.length;

        while(!pq.isEmpty()) {
            Node top = (Node)pq.poll();

            if (visited[top.weapons]) continue;
            visited[top.weapons] = true;

            // if all weapons have been used (obtained)
            if (top.weapons == ((1 << noOfWeapons) - 1))
                return top.shots;

            for (int i = 0; i < damageChart.length; i++) {

                // check if we have already visited the boss
                if (((top.weapons >> i) & 1) > 0) continue;

                int best = bossHealth[i];

                for (int j = 0; j < damageChart.length; j++) {
                    if (i == j) continue;

                    if (((top.weapons >> j) & 1) > 0 && damageChart[i].charAt(j) != '0') {
                        int weaponPower = Integer.parseInt(damageChart[i].charAt(j) + "");
                        int shotsNeeded = bossHealth[i] / weaponPower;
                        if (bossHealth[i] % weaponPower > 0)
                            shotsNeeded++;

                        best = Math.min(best, shotsNeeded);
                    }
                }

                // Defeated the boss, add that to node
                pq.add(new Node((1 << i) | top.weapons, top.shots + best));
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        KiloManX kx = new KiloManX();
        System.out.println(kx.leastShots(new String[] {"070","500","140"}, new int[] {150,150,150}));
    }
}
