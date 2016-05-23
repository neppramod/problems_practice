public class TwoStacks
{
    int[] container = new int[100 * 2];
    int head1 = -1;
    int head2 = 99;

    public void push1(int x)
    {
	if (head1+1 > 99)
	    throw new RuntimeException("Stack 1 overflow");
	head1++;
	container[head1] = x;   
    }

    public void push2(int x)
    {
	if (head2+1>199)
	    throw new RuntimeException("Stack 2 overflow");
	
	head2++;	
	container[head2] = x;
    }

    public int pop1()
    {
	if (head1 < 0)
	    throw new RuntimeException("Stack 1 underflow");
	
	int element = container[head1];
	head1--;
	return element;
    }

    public int pop2()
    {
	if (head2 < 100)
	    throw new RuntimeException("Stack 2 underflow");
	
	int element = container[head2];
	head2--;
	return element;
    }


    public static void main(String[] args) {
	TwoStacks ts = new TwoStacks();
	ts.push1(5);
	ts.push1(3);
	ts.push2(9);
	ts.push2(8);

	for (int i = 0; i < 2; i++) {
	    System.out.println(ts.pop1());
	    System.out.println(ts.pop2());
	}

	ts.pop2();


    }
}
