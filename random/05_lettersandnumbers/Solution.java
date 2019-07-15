import java.util.*;

public class Solution
{
    static int[] longest(int[] arr)
    {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int count = count01(arr, i, j);
                if (count > max)  {
                    max = count;
                    start = i;
                    end = j;
                }
            }
        }

        return Arrays.copyOfRange(arr, start, end+1);
    }

    static int count01(int[] arr, int i, int j)
    {
        int zeros = 0;
        int ones = 0;
        for (int k = i; k <= j; k++) {
            if (arr[k] == 0) zeros++;
            else if (arr[k] == 1) ones++;
        }

        return zeros == ones ? zeros + ones : -1;
    }

    public static void main(String[] args)
    {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,1};
        int[] newArr = longest(arr);
        System.out.println("Length: " + newArr.length + ", " + Arrays.toString(newArr));
        int[] newArr2 = longest2(arr);
        System.out.println("Length2: " + newArr2.length + ", " + Arrays.toString(newArr2));
    }

    static int[] longest2(int[] arr)
    {
        int[] delta = getDeltas(arr);
        int[] maxDeltaDiff = getMaxDeltaDiff(delta);

        if (maxDeltaDiff[0] <= maxDeltaDiff[1]) {
            return Arrays.copyOfRange(arr, maxDeltaDiff[0]+1, maxDeltaDiff[1]+1);  // next Index of where we found the delta
        }

        return null;
    }

    static int[] getDeltas(int[] arr)
    {
        int delta = 0;
        int n = arr.length;
        int[] deltas = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) delta++;
            else delta--;
            deltas[i] = delta;
        }

        return deltas;
    }

    static int[] getMaxDeltaDiff(int[] delta)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = delta.length;
        int[] maxDelta = new int[2];


        for (int i = 0; i < n; i++) {
            if (!map.containsKey(delta[i])) {
                map.put(delta[i], i);
            } else {
                int prev = map.get(delta[i]);
                int dist = i - prev;
                int max = maxDelta[1] - maxDelta[0];
                if (dist > max) {
                    maxDelta[1] = i;
                    maxDelta[0] = prev;
                }
            }
        }


        return maxDelta;
    }
}
