/**
   Relational Operators

   Input
   First line of the input file is an integer t (t < 15) which denotes how many sets of inputs are there.
   Each of the next t lines contain two integers a and b (|a|, |b| < 1000000001).

   Output
   For each line of input produce one line of output. This line contains any one of the relational operators
   ‘>’, ‘<’ or ‘=’, which indicates the relation that is appropriate for the given two numbers.

   <
   >
   =
*/
import java.util.*;
import java.text.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = a - b;
            System.out.println(x > 0 ? ">" : (x < 0 ? "<": "="));
        }
    }
}
