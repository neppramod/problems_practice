import java.util.*;

public class DijkastraShortReach
{
    static class Node implements Comparable
    {
        int number;
        ArrayList<Node> adjacent;
        int cost;
        boolean visited;

        public Node(int number)
        {
            adjacent = new ArrayList<>();
            cost = -1;
            visited = false;
            this.number = number;
        }

        public boolean equals(Object o)
        {
            Node n1 = (Node) o;
            return n1.number == this.number;
        }

        public int compareTo(Object o2)
        {
            Node n1 = (Node) o2;
            return this.cost - n1.cost;
        }

        public String toString()
        {
            return this.cost + "";
        }
    }

    public static void main(String[] args)
    {
        /*
          Node n1 = new Node(5);
          n1.number = 1;

          Node n2 = new Node(5);
          n2.number = 1;

          ArrayList<Node> set = new ArrayList<>();
          set.add(n1);

          if (!set.contains(n2))
          set.add(n2);
        
          System.out.println(set);

        */

        HashMap<String, Integer> pathCost = new HashMap<>();
        ArrayList<Node> nodes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            for (int j = 0; j < M; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int r = sc.nextInt();

                String key = x + ":" + y;
                Integer cost = pathCost.get(key);

                if (cost == null) {
                    pathCost.put(key, cost);

                    Node xNode = new Node(x);
                    Node yNode = new Node(y);
                    if (!nodes.contains(xNode))
                        nodes.add(xNode);
                    if (!nodes.contains(yNode))
                        nodes.add(yNode);                       
                    
                } else {
                    if (cost > r) {
                        pathCost.put(key, r);
                    }
                }
            }

            DijkastraShortReach ds = new DijkastraShortReach();
            int[] mincost = new int[nodes.size() + 1];
            ds.dijkastra(new Node(3), mincost);

            System.out.println(Arrays.toString(mincot));
        }
    }
}
