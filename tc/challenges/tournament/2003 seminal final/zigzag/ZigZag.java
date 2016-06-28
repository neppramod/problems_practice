
import java.util.*;

public class ZigZag
{
    int countzigzag(boolean[] arr)
    {
        ArrayList<Integer> list = new ArrayList<>();
        boolean last = !arr[0];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != last) {
                count++;
                last = arr[i];
            }
        }
        count++;

        return count;
    }

    void builddiff(int[] arr, boolean[] diff)
    {
        for (int i = 1; i < arr.length; i++) {
            diff[i-1] = arr[i] - arr[i-1] > 0 ? true : false;
        }
    }
    
    public int longestZigZag(int[] sequence)
    {
    	if (sequence.length == 1)
    		return 1;
    		
    	boolean[] diff = new boolean[sequence.length-1];
        builddiff(sequence, diff);
        return countzigzag(diff);

    }

    public static void main(String[] args)
    {
        int[] arr = { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
                      600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
                      67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
                      477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
                      249, 22, 176, 279, 23, 22, 617, 462, 459, 244
                    };

        ZigZag zz = new ZigZag();
        System.out.println(zz.longestZigZag(arr));
    }

}
