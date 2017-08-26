import java.util.*;

// FloydWarshall
public class TeamBuilder
{
    public int[] specialLocations(String[] paths)
    {
        int[][] adj = getPathInt(paths);

        for (int k = 0; k < adj.length; k++) {
            for (int j = 0; j < adj.length; j++) {
                for (int i = 0; i < adj.length; i++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }


        for (int i = 0; i < adj.length; i++)
            System.out.println(Arrays.toString(adj[i]));

        int[] pathsint = new int[2];

        for (int i = 0; i < adj.length; i++) {
            int toOther = 0;
            for (int j = 0; j < adj[0].length; j++) {
                if (i == j) continue;
                if (adj[i][j] == 1)toOther++;
            }

            if (toOther == adj.length - 1)
                pathsint[0] = pathsint[0]+1;

            int fromOther = 0;
            for (int k = 0; k < adj[0].length; k++) {
                if (i == k) continue;
                if (adj[k][i] == 1)fromOther++;
            }

            if (fromOther == adj.length - 1)
                pathsint[1] = pathsint[1]+1;
        }

        return pathsint;
    }

    private int[][] getPathInt(String[] paths)
    {
        int[][] intpaths = new int[paths.length][paths[0].length()];
        for (int i = 0; i < paths.length; i++) {
            String[] charStr = paths[i].split("");

            for (int j = 0; j < charStr.length; j++) {

                intpaths[i][j] = Integer.parseInt(charStr[j]);
            }

            System.out.println(Arrays.toString(intpaths[i]));
        }


        return intpaths;
    }

    public static void main(String[] args)
    {
        TeamBuilder tb = new TeamBuilder();
        //System.out.println(Arrays.toString(tb.specialLocations(new String[] {"010","000","110"})));
        System.out.println(Arrays.toString(tb.specialLocations(new String[] {"0110000","1000100","0000001","0010000","0110000","1000010","0001000"})));
        System.out.println(Arrays.toString(tb.specialLocations(new String[] {"01000","00100","00010","00001","10000"})));

    }
}
