// Check for pairs
import java.util.*;

public class Pairs
{
	// return one part of pair, other is sum-return_value
	public static int pairPart(int[] array, int sum)
	{
HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

for (int i = 0; i < array.length; i++) {
	if (map.get(array[i]) == null) {
		map.put(sum - array[i], array[i]);
	} else {
		return array[i];
	}
}	
	return -1;
	}

	public static void main(String[] args)
	{
		int[] array = {1, 4, 45, 6, 10, -8};
		int sum = 16;
		int pairPart = pairPart(array, sum);
		System.out.printf("Pairs: {%d, %d} = %d\n", pairPart, sum-pairPart, sum);
	}
}

