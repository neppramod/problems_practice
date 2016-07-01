import java.util.Arrays;
import java.util.Stack;

/*
  Reverse a stack using recursion
  
  If the next is empty push the item, else reverse
 
 */

public class ReverseStack {
	
	static void reverse(Stack<Integer> stack)
	{
		if (!stack.isEmpty()) {
			int top = stack.pop();
			reverse(stack);
			insertAtBottom(stack, top);
		}
	}
	
	static void insertAtBottom(Stack<Integer> stack, int item)
	{
		if (stack.isEmpty()) {
			stack.push(item);
		} else {
			int top = stack.pop();
			insertAtBottom(stack, item);
			stack.push(top);
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);		
		System.out.println(Arrays.toString(stack.toArray()));
		reverse(stack);
		System.out.println(Arrays.toString(stack.toArray()));
		insertAtBottom(stack, stack.pop());
		System.out.println(Arrays.toString(stack.toArray()));
		
	}
	
	
}

