import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inpt = "nitin";
        printAllPalindromicPartitions(inpt);
    }

    static void printAllPalindromicPartitions(String input)
    {
        ArrayList<ArrayList<String>> allPal = new ArrayList<>();
        Deque<String> deque = new LinkedList<String>();


        getAllPalindromicPartitions(allPal, deque, input.length(), 0, input);

        for (int i = 0; i < allPal.size(); i++) {
            for (int j = 0; j < allPal.get(i).size(); j++) {
                System.out.print(allPal.get(i).get(j) + " ");
            }
            System.out.println();
        }


    }

    static void getAllPalindromicPartitions(ArrayList<ArrayList<String>> allPal, Deque<String> deque, int n, int start, String input)
    {
        if (start >= n) {
            allPal.add(new ArrayList<>(deque));
            return;
        } else {
            for (int i = start; i < n; i++) {
                if (isPalindrome(input, start, i)) {
                    deque.addLast(input.substring(start, i+1));
                    getAllPalindromicPartitions(allPal, deque, n, i + 1, input);
                    deque.removeLast();
                }
            }
        }
    }

    static boolean isPalindrome(String input, int i, int j)
    {
        while (i < j) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
            i++; j--;
        }

        return true;
    }
}
