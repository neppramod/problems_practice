public class Util
{
    public static long max(long... numbers)
    {
        long cur_max = Long.MIN_VALUE;

        for(long number : numbers) {
            cur_max = Math.max(cur_max, number);
        }

        return cur_max;
    }

    public static long min(long... numbers)
    {
        long cur_min = Long.MAX_VALUE;

        for(long number : numbers) {
            cur_min = Math.min(cur_min, number);
        }

        return cur_min;
    }
}
