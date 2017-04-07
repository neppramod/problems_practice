/**
 dividing the land into four independent territories.
    divisa - on border
    NO - NW
    NE - NE
    SE - SE
    SO - SW


NE
divisa
NO
divisa
NE
SO
SE
 */

import java.util.*;
import java.text.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextLine()) {
            int k = sc.nextInt();
            if (k == 0)
                break;
            
            int n = sc.nextInt();
            int m = sc.nextInt();

            while (k -- > 0) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                String output = "divisa";

                if (x < n && y < m) {
                    output = "SO";
                } else if (x < n && y > m) {
                    output = "NO";
                } else if (x > n && y > m) {
                    output = "NE";
                } else if (x > n && y < m) {
                    output = "SE";
                }

                System.out.println(output);
            }
        }
        
    }
}
