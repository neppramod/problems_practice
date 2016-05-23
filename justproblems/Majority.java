import java.util.*;

public class Majority
{
    public static void majority(int[] array)
    {
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	int N = array.length;

	for (int i = 0; i < N; i++) {
	    if (map.get(array[i]) == null) {
		map.put(array[i], 1);
	    } else {
		map.put(array[i], map.get(array[i]) + 1);

		if (map.get(array[i]) > N/2) {
		    System.out.println(array[i]);
		    return;
		}
	    }	   
	}

	System.out.println("NONE");
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	// Number of array inputs
	String line = sc.nextLine();
	String[] inputarr = line.split(" ");
	int N = inputarr.length;

	int[] array = new int[N];

	for (int i = 0; i < N; i++) {
	    array[i] = Integer.parseInt(inputarr[i].trim());
	}

	majority(array);
    }
}
