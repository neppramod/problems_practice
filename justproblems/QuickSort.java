import java.util.*;

public class QuickSort
{
	public void quicksort(int[] array, int low, int high)
{
	if (low >= 0 && high < array.length) {
int index = partition(array, low, high);

if (low < index - 1) {
	quicksort(array, low, index - 1);
}

if (index < high) {
	quicksort(array, index, high);
}
}
}

private int partition(int[] array, int low, int high)
{
int pivot = array[(low + high) / 2];
int i = low;
int j = high;

while (i <= j) {

while (array[i] < pivot) {
	i++;
}

while (array[j] > pivot) {
	j--;
}

if (i <= j) {	// swap
	swap(array, i, j);
	i++;
	j--;
}
}

return i;
}

private void swap(int[] array, int i, int j)
{
	int tmp = array[i];
array[i] = array[j];
array[j] = tmp;
}

public static void main(String[] args)
{
QuickSort qs = new QuickSort();
int[] array = {7, 8, 15, 12, 18, 2, 6, 3};
qs.quicksort(array, 0, array.length - 1);
System.out.println(Arrays.toString(array));
}
}
