/*
  Majority Element: Use a counter to pick a candidate and check if that is majority
 */
import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        int[] arr = new int[] {1, 2, 5, 9, 5, 9, 5, 5, 5};
        int maj = majority(arr);
        if (validateMajority(arr, maj))
            System.out.println("Majority: " + maj);
        else
            System.out.println("No majority element");
    }

    static int majority(int[] arr)
    {
        int counter = 0;
        int N = arr.length;
        int maj = -1;
        for (int i = 0; i < N; i++) {
            if (counter == 0)  maj = arr[i];
            if (arr[i] == maj) counter++;
            else counter--;
        }

        return maj;
    }

    static boolean validateMajority(int[] arr, int element)
    {
        int count = 0;
        int N = arr.length;

        for (int i = 0; i < N; i++) {
            if (arr[i] == element) count++;
        }

        return count > N/2;
    }
}
