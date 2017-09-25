import java.util.*;

public class ATM
{
    public static double result(int w, double b)
    {
        if (w % 5 == 0 && (w + 0.5) <= b) {
            return b-w-0.50;
        }
        return b-0.00;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        double b = sc.nextDouble();
        String formatresult = String.format("%.2f", result(w, b));
        System.out.println(formatresult);
    }
}
