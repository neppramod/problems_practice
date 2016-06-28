public class AllCombinationThatSumUp
{
	static void printsums(String begin, int s, int n)
	{

		if (n==1) {
			System.out.println(begin+s);
			return;
		}
		// if n > 1
		for (int i = 0; i < s; i++) {
			String x = begin + i + "+";
			printsums(x, s-i, n-1);
		}

	}

	public static void main(String[] args)
	{
		printsums("", 5, 4);
	}
}
