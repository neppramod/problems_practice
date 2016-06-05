import java.util.*;

public class ExploringNumbers
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

    public int numberOfSteps(int n)
    {
        boolean[] prime = seive(1000000000);
        
        int i = 1;
        int cur = n;

        while (i <=n) {
            if (prime[cur])
                return i;

            cur = sumsquares(cur);
            
            i++;
        }

        return -1;
    }

    private int sumsquares(int n)
    {
        int num = n;
        int sum = 0;
		
        while (num > 0) {
            int x = num % 10;
            sum += x * x;
            num /= 10;
        }
		
        return sum;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ExploringNumbers en = new ExploringNumbers();
        System.out.println(en.numberOfSteps(sc.nextInt()));
    }
}
