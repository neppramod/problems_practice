import java.util.*;

public class Sieve
{
    boolean[] seive(int n)
    {
        if (n < 2)
            return new boolean[0];
        
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        
        prime[0] = false;
        prime[1] = false;
        
        int m = (int)Math.sqrt(n);

        for (int i = 2; i <= m; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j+=i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }

    public static void main(String[] args)
    {
        boolean[] prime = seive(479001599);
        System.out.println(prime[479001599]);
    }
}
