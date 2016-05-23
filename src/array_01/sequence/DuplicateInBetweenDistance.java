package array_01.sequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Find if duplicate elements exists in an array between a given distance
 */
public class DuplicateInBetweenDistance {

    public static void main(String[] args) {
        int[] array = {1,4,6,2,7,4};
        System.out.println(hasDuplicate(array, 4));
    }

    static boolean hasDuplicate(int[] array, int k) {
        // Key is number, value is index
        Map<Integer, Integer> numbersMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (!numbersMap.containsKey(array[i])) {
                numbersMap.put(array[i], i);
            } else {
                int previousIndex = numbersMap.get(array[i]);
                if (i - previousIndex <= k) {
                    return true;
                } else {
                    numbersMap.put(array[i], i);
                }
            }
        }

        return false;
    }
}
