import java.util.*;

public class Dubs
{
    public long count(long L, long R)
    {
        long sum = 0;
        for (long i = L; i <= R; i++) {
            int r1 = (int)i%10;
            int r2 = (int)(i/10)%10;

            if (r1 == r2)
                sum++;
        }

        return sum;
    }

    public long newcount(long L, long R)
    {
        long sum = 0;
        long ll = firstDouble(L);
        long lastfound = 10;
        
        for (long i = ll; i <= R; i+=11) {
            sum++;
            lastfound = i;

            // special case of 100
            if (i % 100 == 99 && i + 1 <= R) {
                sum++;
            }
        }
        
        return sum;
    }

    private long firstDouble(long number)
    {
        int i = 0;
        while (!isDouble(number)) {            
            number++;
            i++;
        }
        return number;
    }

    private boolean isDouble(long number)
    {
        int r1 = (int)number%10;
        int r2 = (int)((number / 10) % 10);
        if (r1 == r2)
            return true;
        return false;
    }

    public static void main(String[] args)
    {
        Dubs d = new Dubs();
        //System.out.println(d.newcount(10L,1_000_000_000_0L));
        //System.out.println(d.newcount(91750002841L, 91751522033L));
        //System.out.println(d.newcount(1111111L, 111111111L));
        System.out.println(d.newcount(10,1000 ));
    }
}
