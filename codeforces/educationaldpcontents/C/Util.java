public class Util
{
    public static int max(int... numbers)
    {
        int cur_max = Integer.MIN_VALUE;

        for(int number : numbers) {
            cur_max = Math.max(cur_max, number);
        }

        return cur_max;
    }

    public static int min(int... numbers)
    {
        int cur_min = Integer.MAX_VALUE;

        for(int number : numbers) {
            cur_min = Math.min(cur_min, number);
        }

        return cur_min;
    }
}
