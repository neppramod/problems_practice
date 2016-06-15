import java.util.*;

public class YahtzeeScore
{
    public int maxPoints(int[] toss)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < toss.length; i++) {
            if (map.containsKey(toss[i])) {
                int value = toss[i];
                value += map.get(toss[i]);

                if (value > max) {
                    max = value;
                }

                map.put(toss[i], value);
            } else {
                int value = toss[i];
                if (value > max) {
                    max = value;
                }
                map.put(toss[i], value);
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        YahtzeeScore ys = new YahtzeeScore();
        int[] array = {2, 2, 3, 5, 4};
        System.out.println(ys.maxPoints(array));
    }
    
}
