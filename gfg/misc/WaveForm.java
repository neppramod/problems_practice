// Not tested
public class WaveForm
{
    // 1 2 3 4 5
    // 2 1 4 3 5
    // arr[0] >= arr[1] <= arr[2]
    void sortInWave(int[] arr)
    {
        for (int i = 1; i < n-1; i+= 2) {
            if (arr[i-1] < arr[i])
                swap(arr, i, i-1);
            if (arr[i+1] < arr[i])
                swap(arr, i, i+1);
        }
    }

    void swap(int[] arr, int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
