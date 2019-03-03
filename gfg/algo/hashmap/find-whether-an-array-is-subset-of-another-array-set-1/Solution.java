import java.util.*;

public class Solution
{
    public static isSubset(int arr1[], int arr2[], int m, int n) {
        HashMap<Integer, Integer> map1 = new HashMap<>();

        for (int i = 0; i < m; i++) {
            map1.put(arr1[i], 1);
        }

        for (int i = 0; i < n; i++) {
            if (!map1.containsKey(arr2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


    }
}
