/*
   Produce a list of the words contained in a document

   Solution: Add words that have spaces to a set, print that
*/


import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (sc.hasNext()) {
            String s = sc.next();
            set.add(s);
        }

        System.out.println(set.toString());
    }


}
