import java.util.*;

public class FillingJars
{
    public static void averageCandies()
    {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long M = sc.nextLong();
		long sum = 0;

		for (int i = 0; i < M; i++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long k = sc.nextLong();
			sum += (b + 1 - a) * k;
		}

		System.out.println(sum / N);
    }

    public static void main(String[] args)
	{
		averageCandies();
	}
}
