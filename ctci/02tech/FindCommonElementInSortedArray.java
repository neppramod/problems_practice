import java.util.*;

public class FindCommonElementInSortedArray
{
    static ArrayList<Integer> findCommon(int[] a, int[] b)
    {
	ArrayList<Integer> result = new ArrayList<>();
	int i = 0;
	int j = 0;

	while (i < a.length && j < b.length) {
	    if (a[i] == b[j]) {
		result.add(a[i]);
		i++;
		j++;
	    } else if (a[i] < b[j]) {
		i++;
	    } else {
		j++;
	    }
	}

	return result;
    }

    public static void main(String[] args)
    {
	int[] b = {3, 6, 7, 8, 9, 10, 12, 15};
	int[] a = {1, 3, 8, 11, 12};

	System.out.println(findCommon(a, b));
    }
}
