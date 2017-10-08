import java.util.*;

public class NSTEPS
{
    static int num(int x, int y)
    {
        int min = Math.min(x, y);
        int sum = 0;
        while (min >= 4) {
            sum += 8;
            min-=4;
            x-=4;
            y-=4;
        }

        if (x == 1 && y == 1) sum+=1;
        if (x == 2 && y == 0) sum+=2;
        if (x == 3 && y == 1) sum+=3;
        if (x == 2 && y == 2) sum+=4;
        if (x == 3 && y == 3) sum+=5;
        if (x == 4 && y == 2) sum+=6;
        if (x == 5 && y == 3) sum+=7;

        return sum;
    }

    static boolean isinline(int x, int y)
    {
        int min = Math.min(x, y);

        while (min >= 4) {
            min-=4;
            x-=4;
            y-=4;
        }

        if (x == 0 && y == 0) return true;
        if (x == 1 && y == 1) return true;
        if (x == 2 && y == 0) return true;
        if (x == 3 && y == 1) return true;
        if (x == 2 && y == 2) return true;
        if (x == 3 && y == 3) return true;
        if (x == 4 && y == 2) return true;
        if (x == 5 && y == 3) return true;

        return false;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (isinline(x, y)) {
                System.out.println(num(x,y));
            } else {
                System.out.println("No Number");
            }
        }
    }
}
