import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(new File("names.txt"));
        String longLine = sc.nextLine();
        String[] all = longLine.split(",");

        //System.out.println(all[0]);
        //System.out.println(all[5]);
        Arrays.sort(all);

        long answer = 0;
        for (int i = 0; i < all.length; i++) {
            long cur = 0;
            for (int j = 1; j < all[i].length() - 1; j++) {
                char ch = all[i].charAt(j);
                if (ch >= 'A' && ch  <= 'Z') {
                    cur += (ch - 'A');
                } else {
                    cur += (ch - 'a');
                }

            }
            answer += (cur * (i+1));
        }

        System.out.println(answer);

    }
}
