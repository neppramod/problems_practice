import java.util.*;

/**

   • turn the dial clockwise 2 full turns
   • stop at the first number of the combination
   • turn the dial counter-clockwise 1 full turn
   • continue turning counter-clockwise until the 2nd number
   is reached
   • turn the dial clockwise again until the 3rd number is
   reached
   • pull the shank and the lock will open.

   Sample Input
   0 30 0 30  = 80 + 10 (0 -> 30) + 40 + 10 (30 -> 0) + 10 = 150 = 9 * 150 = 1350
   5 35 5 35  = 80 + 10 (5 -> 35) + 40 + 10 (35 -> 5) + 10 = 150 = 9 * 150 = 1350
   0 20 0 20  = 80 + 20 (0 -> 20) + 40 + 20 (20 -> 0) + 20 = 180 = 9 * 180 = 1620
   7 27 7 27  = 80 + 20 (7 -> 27) + 40 + 20 (27 -> 7) + 20 = 180 = 9 * 180 = 1620
   0 10 0 10 = 80 + 30 (40 - 10 + 0) + 40 + 30 (40 - 10 + 0) + 30 = 9 * 210 = 1890
   9 19 9 19 = 120 + (40 - 19 + 9) + (40 - 19 + 9) + (40 - 19 + 9) = 9 * 210 = 1890
   0 0 0 0
   Sample Output
   1350
   1350
   1620
   1620
   1890
   1890
 */

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int start = sc.nextInt();
            int first = sc.nextInt();
            int second = sc.nextInt();
            int third = sc.nextInt();

            if (start == 0 && first == 0 && second == 0 && third == 0)
                break;

            int distanceMoved = 120 + (40 - first + start) + (40 - first + second) + (40 - third + second);
            System.out.println(distanceMoved * 9);
        }
    }
}
