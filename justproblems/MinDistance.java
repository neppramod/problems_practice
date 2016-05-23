import java.util.*;

public class MinDistance {
    public int minDistance(int[] array, int X, int Y) {
        HashMap < Integer, Integer > map = new HashMap < Integer, Integer > ();
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == X) {
                map.put(X, i);
            } else if (array[i] == Y) {
                map.put(Y, i);
            }

            if (map.get(X) != null && map.get(Y) != null && Math.abs(map.get(X) - map.get(Y)) < diff) {
                diff = Math.abs(map.get(X) - map.get(Y));
            }
         }

         return diff;
     }

     public static void main(String[] args) {
	//int[] arr = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 2};
	//int[] arr = {2, 5, 3, 5, 4, 4, 2, 3};
	int[] arr = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
	MinDistance md = new MinDistance();
	System.out.println(md.minDistance(arr, 3, 6));
     }
}

