/**
   Given a string that contains only digits from 0 to 9, and an integer value, target. Find out how many expressions are possible which evaluate to target using binary operator +, – and * in given string of digits.
   
   We will use EvaluateExpression to evaluate the built expression

   To built the expression we use similar code as PrintAllStringsOfLengthKFromNChars
*/

import java.util.*;

public class PrintAllPossibleExpressionsThatEvulateToATarget {
    public static void main(String[] args) {
	PrintAllPossibleExpressionsThatEvulateToATarget sol = new PrintAllPossibleExpressionsThatEvulateToATarget();
	String s = "125";
	int target = 7;
	sol.printAllPossibleExpressions(s, target);
    }

	char[] set = { '+', '-', '*' };
    
    public void printAllPossibleExpressions(String s, int target) {
	EvaluateExpression eval = new EvaluateExpression();
	printAllPossibleExpressions(s, "", 0, s.length(), target, eval);
	gogaal();
    }

    void printAllPossibleExpressions(String s, String exp, int start, int end, int target, EvaluateExpression eval) {
	if (start >= end) {
	    if (eval.eval(exp) == target) {
		System.out.println(exp);
	    }
	} else {
	    for (int i = start; i < end; i++) {
		String sub = s.substring(start, i + 1);

		if (i < end - 1) {
		    for (char c : set) {
			printAllPossibleExpressions(s, exp + sub + c, i + 1, end, target, eval);			
		    }
		} else {
		    printAllPossibleExpressions(s, exp + sub, i + 1, end, target, eval);
		}
	    }
	}
    }
}

