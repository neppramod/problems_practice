/**
   UVa 01124 - Celebrity Jeopardy (LA 2681, just echo/re-print the input again)

   // Echo input

   You have to write a program which finds the simplest possible equation to be solved given the answer, considering all possible equations using the standard mathematical symbols in the usual manner. In this context, simplest can be defined unambiguously several different ways leading to the same path of resolution. For now, find the equation whose transformation into the desired answer requires the least effort. For example, given the answer X = 2, you might create the equation 9 − X = 7. Alternately, you could build the system X > 0; X 2 = 4. These may not be the simplest possible equations. Solving these mind-scratchers might be hard for a celebrity.
*/

import java.util.*;
import java.text.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
