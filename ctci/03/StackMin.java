public class StackMin
{
    private static final int STACK_SIZE = 100;

    private static class Node
    {
        int data;
        int min;
        public Node(int d, int m) { data = d; min = m; }
    }

    private Node[] array = new Node[STACK_SIZE];
    private int top = -1;

    public void push(int item)
    {
        if (top + 1 > STACK_SIZE) {
            throw new RuntimeException("Stack Overflow");
        }

        int min;
        if (top == -1) {
            min = item;
        } else {
            min = array[top].min;
        }

        if (item < min) {
            min = item;
        }

        top++;
        array[top] = new Node(item, min);
    }

    public int pop()
    {
        if (top < 0) {
            throw new RuntimeException("Stack underflow");
        }

        int item = array[top].data;
        top--;
        return item;
    }

    public int min()
    {
        if (top < 0) {
            throw new RuntimeException("Stack underflow");
        }

        return array[top].min;
    }

    public boolean isEmpty()
    {
        return top < 0;
    }

    public static void main(String[] args)
    {
        StackMin sm = new StackMin();
        sm.push(7);
        sm.push(3);
        sm.push(8);
        sm.push(5);
        sm.push(2);
        sm.push(7);

        while(!sm.isEmpty()) {            
            System.out.println("Min: " + sm.min() + ", Data (pop): " + sm.pop());
        }
    }
}
