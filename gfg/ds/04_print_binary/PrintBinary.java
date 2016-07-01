import java.util.*;

public class PrintBinary
{
	static void printBinary(int n)
	{
		Queue<String> queue = new LinkedList<>();
		queue.add("1");

		while (n-- > 0) {
			String s1 = queue.poll();
			System.out.println(s1);
			queue.add(s1 + "0");
			queue.add(s1 + "1");
		}
	}

	public static void main(String[] args)
	{
		printBinary(10);
	}
}
