public class Euclidian
{
    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;

        return gcd(b, a%b);
    }

    public static int lcm(int a, int b)
    {
        return a * b / gcd(a,b);
    }

    public static int gcd2(int a, int b)
    {
        for (int i = Math.min(a,b); i >= 1; i--) {
            if (a%i == 0 && b%i == 0)
                return i;
        }
        return -1;
    }

    public static void print(int value)
    {
        System.out.println(value);
    }

    public static void main(String[] args)
    {
        print(lcm(39, 18));
        print(gcd(39, 18));
        print(gcd2(39, 18));
    }
}
