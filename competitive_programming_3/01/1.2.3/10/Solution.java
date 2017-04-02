/**
   Given a string, replace all ‘special words’ of length 3 with 3 stars
   special word = lowercase alphabet followed by two consecutive digits.

   // line: *** and *** will be replaced, aa24 and a872 will not

 */

import java.util.*;
import java.text.*;

public class Solution
{
    public static void main(String[] args) {
        String input ="line: a70 and z72 will be replaced, aa24 and a872 will not";
        String replaced = input.replaceAll("\\b[a-z]\\d{2}\\b", "***");
        System.out.println(replaced);
    }
}
