/**
   Given a string that represents a base X number, convert it to an equivalent string in base Y, 2 <= X,Y <= 36
 */

import java.util.*;
import java.text.*;

// F7DC
public class Solution
{
    public static void main(String[] args) {
        String base7Number = "63452";
        Integer bs7Num = Integer.parseInt(base7Number, 10);
        System.out.println(Integer.toString(bs7Num, 16)); // BitInteger.toString(int radix)
    }
}
