/**
   Evaluate infix mathematical expression

   Support (), +, -, * and /
   We don't do divide by zero check with /

   This is a utility class to be used with other code
*/


import java.util.*;

public class EvaluateExpression {
    public static void main(String[] args) {
	EvaluateExpression sol = new EvaluateExpression();
	String s = "1+2+3*(5-2)";
	System.out.println(sol.eval(s));
    }

    public int eval(String s) {
	if (s == null || s.length() == 0) {
	    return 0;
	}

	Stack<Integer> val = new Stack<>();
	Stack<Character> op = new Stack<>();

	char[] cs = s.toCharArray();
	int n = cs.length;

	for (int i = 0; i < n; i++) {
	    if (cs[i] == ' ') {
		continue;
	    } else if (cs[i] == '(') {
		op.push(cs[i]);
	    } else if (cs[i] == ')') {
		while (!op.isEmpty() && op.peek() != '(') {
		    val.push(apply(op.pop(), val.pop(), val.pop()));
		}

		if (!op.isEmpty()) {
		    op.pop();
		}
	    } else if (isNumeric(cs[i])) {
		int sum = 0;
		while (i < n && isNumeric(cs[i])) {
		    sum = sum * 10 + cs[i] - '0';
		    i++;
		}
		val.push(sum);
		i--;  // i has gone 1 past numeric value, bring it back
	    } else if (isOperator(cs[i])) {
		while (!op.isEmpty() && isHigherPrecedence(op.peek(), cs[i])) {
		    val.push(apply(op.pop(), val.pop(), val.pop()));
		}

		op.push(cs[i]);
	    }
	}

	while (!op.isEmpty()) {
	    val.push(apply(op.pop(), val.pop(), val.pop()));
	}

	if (!val.isEmpty()) {
		return val.pop();
	} else {
		return 0;
	}
    }

    private boolean isNumeric(char c) {
	return c >= '0' && c <= '9';
    }

    private boolean isHigherPrecedence(char op1, char op2) {
	if (op1 == '(' || op1 == ')') {
	    return false;
	} else if ((op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/')) {
	    return false;
	} else {
	    return true;
	}
    }

    private boolean isOperator(char c) {
	return c == '*' || c == '/' || c == '+' || c == '-';
    }

    private int apply(char oper, int val2, int val1) {
	if (oper == '+') {
	    return val1 + val2;
	} else if (oper == '-') {
	    return val1 - val2;
	} else if (oper == '*') {
	    return val1 * val2;
	} else if (oper == '/') {
	    return val1 / val2;
	} else {
	    return 0;
	}
    }
}
