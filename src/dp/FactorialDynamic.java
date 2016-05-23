package dp;

public class FactorialDynamic {
    public static long factorial(int n)
    {
        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
