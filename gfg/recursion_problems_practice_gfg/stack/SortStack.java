import java.util.*;

public class SortStack {
    public static void main(String[] args) {
	    SortStack sol = new SortStack();
        Stack<Character> stack = new Stack<>();
        stack.push('4');
        stack.push('5');
        stack.push('3');
        stack.push('7');
        stack.push('1');

        sol.sort(stack);
        System.out.println(stack);
	}

    public void sort(Stack<Character> stack) {
        if (!stack.isEmpty()) {
            char x = stack.pop();
            sort(stack);
            pushSorted(stack, x);
        }
    }

    private void pushSorted(Stack<Character> stack, char x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            char a = stack.pop();
            if (a > x) {
                char tmp = a;
                a = x;
                x = tmp;
            }
            pushSorted(stack, x);
            stack.push(a);
        }
    }
    
}
