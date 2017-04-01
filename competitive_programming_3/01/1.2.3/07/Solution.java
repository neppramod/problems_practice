/**
Generate all possible permutations of {'A', 'B', 'C', ..., 'J'}, the first N = 10 letters in the alphabet (see Section 3.2.1).

ABC
ACB
BAC
BCA
CAB
CBA

*/

import java.util.*;
import java.text.*;

public class Solution
{
    public static void main(String[] args) {
        // List<Character> charList = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J');
        List<Character> charList = Arrays.asList('A', 'B', 'C');
        permutation(charList, "");
    }

    public static void permutation(List<Character> charList, String prefix) {

        // Always get to the same size: Permutation, Order Matters !! (POM)
        if (charList.size() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < charList.size(); i++) {
                List<Character> newList = new ArrayList<>(charList);
                newList.remove(i);

                // Pick a single value at each iteration and attach everything else to it.
                String newString = prefix + charList.get(i);
                permutation(newList, newString);
            }
        }
    }
}
