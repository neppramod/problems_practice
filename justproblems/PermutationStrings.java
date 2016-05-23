public class PermutationStrings
{
    public void swap(char[] array, int i, int j)
    {
	char tmp = array[i];
	array[i] = array[j];
	array[j] = tmp;
    }

    public void print(char[] array, int low, int high)
    {
	if (low == high) {
	    System.out.println(array);
	} else {
	    for (int j = low; j <= high; j++) {
		swap(array, low, j);
		print(array, low + 1, high);
		swap(array, low, j);
	    }
	}
    }

    public static void main(String[] args)
    {
	PermutationStrings ps = new PermutationStrings();
	char[] array = {'a','b','c'};
	ps.print(array, 0, 2);
    }
}
