import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = "babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab";
        String p ="***bba**a*bbba**aab**b";

        Boolean[][] visited = new Boolean[s.length() + 1][p.length() + 1];
        System.out.println(isMatch(s, p, visited));

    }

    public static boolean isMatch(String s, String p, Boolean[][] visited) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        } if (p.length() == 0 && s.length() > 0) {
            return false;
        } else if (visited[s.length()][p.length()] != null) {
            return visited[s.length()][p.length()];
        } else if (p.length() > 0 && s.length() == 0) {
            if (p.charAt(0) == '*') {
                return visited[s.length()][p.length()] = isMatch(s, p.substring(1), visited);
            } else {
                return false;
            }
        } else {

            char sc = s.charAt(0);
            char pc = p.charAt(0);
            //System.out.println("Sc: " + sc + ", PC: " + pc);

            if (pc == sc || pc == '?') {
                visited[s.length()][p.length()] = isMatch(s.substring(1), p.substring(1), visited);
            } else if (pc == '*') {
                //System.out.println("Match *");
                visited[s.length()][p.length()] = isMatch(s.substring(1), p.substring(1), visited) || isMatch(s.substring(1), p, visited) || isMatch(s, p.substring(1), visited);
            } else {
                visited[s.length()][p.length()] = false;
            }
            return visited[s.length()][p.length()];
        }
    }

    public static void pA1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }

    public static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pA1(arr[i]);
        }
    }
}
