import java.util.*;

public class QueueUsingStack
{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    void enque(int element)
    {
        stack1.push(element);
    }

    int deque()
    {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            throw new RuntimeException("Queue underflow");
        }
    }

	boolean isEmpty()
	{
		if (stack1.isEmpty() && stack2.isEmpty())
			return true;
		else
			return false;
	}


	public static void main(String[] args)
	{
		QueueUsingStack queue = new QueueUsingStack();
		queue.enque(3);
		queue.enque(9);
		queue.enque(7);


		if (!queue.isEmpty()) {
	    	System.out.print(queue.deque() + " ");
	    	System.out.print(queue.deque() + " ");
		}

		queue.enque(2);
		queue.enque(8);
		queue.enque(5);
		queue.enque(4);

		while(!queue.isEmpty()) {
			System.out.print(queue.deque() + " ");
		}
		
		System.out.println();
	}
}

