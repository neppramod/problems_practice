/**
6. Given a list of sorted integers integers L of size up to 1M items, determine whether a value v exists in L with no more than 20 comparisons
(more details in Section 2.2)
*/
import java.util.*;
import java.text.*;

public class Solution
{
    public static void main(String[] args) {
        List<Integer> sortedList = Arrays.asList(2, 5, 7, 12, 16, 18, 25, 29, 52, 71);
        System.out.println(Collections.binarySearch(sortedList, 7));
    }
}
