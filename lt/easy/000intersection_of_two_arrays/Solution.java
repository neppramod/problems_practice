import java.util.*;



public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();



        for (int num : nums1) {

            set.add(num);

        }



        ArrayList<Integer> intersection = new ArrayList<>();

        for (int num : nums2) {

            if (set.contains(num)) {

                intersection.add(num);

                    }

        }



        int[] intersectionarray = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            intersectionarray[i] = intersection.get(i);
        }

        return intersectionarray;

    }



    public static void main(String[] args) {

        Solution sln = new Solution();
        

        System.out.println(Arrays.toString());

    }

}
