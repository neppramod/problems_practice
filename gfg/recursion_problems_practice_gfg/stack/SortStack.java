import java.util.*;

public class SortStack {
    public static void main(String[] args) {
	    SortStack sol = new SortStack();
        Stack<Character> stack = new Stack<>();
        stack.push('4');
        stack.push('5');
        stack.push('3');
        stack.push('7');
        stack.push('5');
        stack.push('1');

        sol.sort(stack);  // small at top
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
        if (stack.isEmpty() || x > stack.peek()) {  // change > to < to sort in reverse order
            stack.push(x);
        } else {
            char a = stack.pop();
            pushSorted(stack, x);
            stack.push(a);
        }
    }
    
}
