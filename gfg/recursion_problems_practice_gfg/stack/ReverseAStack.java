import java.util.*;

public class ReverseAStack {
    public static void main(String[] args) {
	    ReverseAStack sol = new ReverseAStack();
        Stack<Character> stack = new Stack<>();
        stack.push('1');
        stack.push('2');
        stack.push('3');
        stack.push('4');
        System.out.println("Before");
        System.out.println(stack);
        sol.reverseStack(stack);
        System.out.println("After");
        System.out.println(stack);
	}

    public void reverseStack(Stack<Character> stack) {
        if (!stack.isEmpty()) {
            char  x = stack.pop();
            reverseStack(stack);
            pushAtBottom(stack, x);
        }
    }

    private void pushAtBottom(Stack<Character> stack, char x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            char a = stack.pop();
            pushAtBottom(stack, x);
            stack.push(a);
        }
    }
}
