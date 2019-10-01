import java.util.*;

public class PythagorianTriplet
{
    static boolean checkTriplet(int[] arr)
    {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i] * arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (set.contains(arr[i] * arr[i] + arr[j] * arr[j])) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        int[] arr ={ 3, 2, 4, 6, 5 };
        System.out.println(checkTriplet(arr));
    }
}
