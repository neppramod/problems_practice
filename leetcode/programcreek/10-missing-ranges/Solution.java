import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int[] arr = {0, 1, 3, 50, 75};
        List<String> results = findMissingRanges(arr, 0, 99);
        System.out.println(results);
        // [2, 4->49, 51->74, 76->99]
    }

    static List<String> findMissingRanges(int[] arr, int lower, int upper) {
	List<String> list = new ArrayList<>();
	if (lower == Integer.MAX_VALUE) {
	    return list;
	}

	int start = lower;
	int i = 0;
	int n = arr.length;
	
	while (i < n) {
	    if (i < n-1 && arr[i] == arr[i+1]) {
		i++;
		continue;
	    }

	    if (arr[i] == start) {
		start++;
	    } else {
		list.add(getRange(start, arr[i]-1));
		start = arr[i]+1;
	    }
	    i++;
	}

	if (start < upper) {
	    list.add(getRange(start, upper));
	}

	return list;
    }

    static String getRange(int i, int j) {
	return i == j ? String.valueOf(i) : i + "->" + j;
    }

}
