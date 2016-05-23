package stack_parenthesis;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] letters = line.split("");
        Stack stack = new Stack();

        for (String l : letters) {
            if (l.equals("(")) {
                stack.push("(");
            } else if (l.equals(")")) {
                if (stack.empty())
                    throw new RuntimeException("No matching (");
                stack.pop();
            }
        }

        if (!stack.empty())
            throw new RuntimeException("Mismatching parenthesis");
    }
}
