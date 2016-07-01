import java.util.*;

public class SortStack {
	static void sort(Stack<Integer> stack)
	{
		if (!stack.isEmpty()) {
			int top = stack.pop();
			sort(stack);
			putSorted(stack, top);
		}
	}

	private static void putSorted(Stack<Integer> stack, int item) {
		if (stack.isEmpty() || stack.peek() < item) {
			stack.push(item);
		} else {
			int top = stack.pop();
			putSorted(stack, item);
			stack.push(top);
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-3);
		stack.push(14);
		stack.push(18);
		stack.push(-5);
		stack.push(30);
		
		System.out.println(Arrays.toString(stack.toArray()));
		sort(stack);
		System.out.println(Arrays.toString(stack.toArray()));
	}
}

