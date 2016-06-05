public class SumSquares
{
	public static int sumsquares(int n)
	{
		int num = n;
		int sum = 0;
		
		while (num > 0) {
			int x = num % 10;
			sum += x * x;
			num /= 10;
		}
		
		return sum;
	}
	
	public static void main(String[] args)
	{
		System.out.println(sumsquares(17));
	}
}
