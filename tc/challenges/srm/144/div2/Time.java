import java.util.*;

public class Time
{
    public String whatTime(int seconds)
    {
        int cursec = seconds%60;
        int mins = seconds/60;
        int curmins = mins % 60;
        int hrs = mins / 60;

        return hrs + ":" + curmins + ":" + cursec;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Time t = new Time();
        System.out.println(t.whatTime(sc.nextInt()));
    }
}
