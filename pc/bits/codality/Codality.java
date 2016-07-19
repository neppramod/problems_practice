import java.util.*;

public class Codality
{
    static int codality(int n)
    {
        String s = Integer.toString(n, 2);        
        int[] L = new int[s.length()];
        L[0] = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                L[i] = L[i-1] + 1;
            } else {                
                L[i] = 0;
            }
        }

        int max = 0;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }
        
        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(codality(4545323));
    }
}
