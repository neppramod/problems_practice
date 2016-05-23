import java.util.*;

public class DuplicatesInArray
{
    public List<Integer> duplicatesInArray(int[] array)
    {
	List<Integer> duplicates = new ArrayList<Integer>();

	for (int i = 0; i < array.length; i++) {
		if (array[Math.abs(array[i])] > 0) {
			array[Math.abs(array[i])] = -array[Math.abs(array[i])];
		} else {
			duplicates.add(Math.abs(array[i]));
		}
	}

	return duplicates;		
    }

    public static void main(String[] args)
    {
	int[] array = {1, 2, 3, 1, 3, 6, 6};
	
	List<Integer> duplicates = new DuplicatesInArray().duplicatesInArray(array);
	System.out.println(duplicates);
    }
}
