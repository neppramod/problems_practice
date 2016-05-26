public class CountWays
{
	public static int countWaysBook(int n)
	{
		if (n < 0)
			return 0;
		else if (n == 0)
			return 1;
		else
			return countWaysBook(n-1) + countWaysBook(n-2) + countWaysBook(n-3);
	}

	public static void main(String[] args)
	{
		System.out.println(countWaysBook(10));
	}
}
