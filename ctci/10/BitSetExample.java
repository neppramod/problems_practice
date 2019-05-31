import java.util.*;

public class BitSetExample
{
    public static void main(String[] args) {

        boolean[] bits = new boolean[4000000000L];


        Random random = new Random();
        for (long i = 0; i < 4000000000L; i++) {
            if (random.nextLong() % 5 == 0) {
                bits[(int)i] = true;
            }
        }

        System.out.println(Arrays.toString(bits));


    }
}
