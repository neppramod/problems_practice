import java.util.*;

public class TowersOfHanoi
{
    static void move(int n, Stack<Integer> src, Stack<Integer> destination, Stack<Integer> aux)
    {
	if (n <= 0)
	    return;

	move(n-1, src, aux, destination);
	// move nth disk from src to destination using aux
	int data = src.pop();
	System.out.println("Moving: " + data);
	destination.push(data);
	move(n-1, aux, destination, src);
    }

    public static void main(String[] args)
    {
	int N = 4;
	Stack<Integer> src = new Stack<Integer>();
	Stack<Integer> destination = new Stack<Integer>();
	Stack<Integer> aux = new Stack<Integer>();

	for (int i = 4; i >= 1; i--) {
	    src.push(i);
	}

	move(4, src, destination, aux);

	for (int i = 0; i < 4; i++) {
	    int d = destination.pop();
	    System.out.println(d);
	}
    }
}
