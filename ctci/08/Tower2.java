import java.util.*;

public class Tower2
{
    static void move(int n, int from, int to, int using)
    {
	if (n <= 0) return;

        move(n-1, from, using, to);
        System.out.printf("Moved %d from %d to %d\n", n, from, to);
        move(n-1, using, to, from);
    }

    public static void main(String[] args)
    {
        int n = 3;
        move(n, 1, 3, 2);
    }
}
