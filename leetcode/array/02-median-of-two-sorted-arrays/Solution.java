import java.util.*;


// Solves in O(n+m), unlike requirement, but AC
public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //int arr1[] = {2, 5, 6, 7, 8, 9};
        //int arr2[] = {4, 5, 8, 9, 15};

        int arr1[] = {};
        int arr2[] = {4, 8, 9, 12};

        double result = findMedianSortedArrays(arr1, arr2);

        System.out.println(result);

    }



    /*
      arr1[] = {2, 5, 6, 7, 8, 9}
      arr2[] = {4, 5, 8, 9, 15}


      arr[] = {2, 4, 5, 5, 6, 7, 8, 8, 9, 9, 15}  => 7

      arr1[] = {2, 5, 6, 7, 8, 9}
      arr2[] = {4, 5, 8, 9, 12, 15}

      l1 = 0, r1 = 5
      l2 = 0, r2 = 5

      m1 = (l1 + r1)/ 2 = 2, a1[m1] = 6
      m2 = (l2 + r2) / 2 = 2, a2[m2] = 8

    */


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int n = n1 + n2;

        int i = 0, j = 0;
        int e1 = 0, e2 = 0;

        while (i + j <= n/2) {
            e2 = e1;
            if (i < n1 && j < n2) {
                if (nums1[i] <= nums2[j]) {
                    e1 = nums1[i];
                    i++;
                } else {
                    e1 = nums2[j];
                    j++;
                }
            } else if (i < n1) {
                e1 = nums1[i];
                i++;
            } else {
                e1 = nums2[j];
                j++;
            }
        }

        if (n % 2 == 0) {
            return (double)(e1 + e2)/2.0;
        } else {
            return (double)e1;
        }

    }

}
