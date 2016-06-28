public class CompareMaxExample
{
	public static <T extends Comparable<T>> T findMax(T a, T b)
	{
		int n = a.compareTo(b);
		
		return n < 0 ? b : a;
	}
	
	public static void main(String[] args)
	{
		System.out.println(findMax(2,3));
		System.out.println(findMax("happy","hello"));
	}
}
