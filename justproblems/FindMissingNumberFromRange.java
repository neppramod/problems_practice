import java.util.*;

public class FindMissingNumberFromRange
{
	int missingNumber(int[] array)
	{
		int res = array[0];
		for (int i = 1; i <= array.length + 1; i++) {
			res = res ^ i;
			if (i < array.length)
				res = res ^ array[i];
		}
		return res;
	}

	public static void main(String[] args)
	{
		int[] arr = {1, 2, 4, 6, 3, 7, 8};
		System.out.println(new FindMissingNumberFromRange().missingNumber(arr));
	}
}
