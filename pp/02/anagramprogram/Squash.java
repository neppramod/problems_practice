import java.util.*;

public class Squash
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String oldkey = "";
        int linenum = 0;
        while (sc.hasNext()) {
            String key = sc.next();
            String word = sc.next();

            if (!oldkey.equals(key) && linenum > 0) {
                System.out.println();
            }

            oldkey = key;
            System.out.printf("%s ", word);
            linenum++;
        }
        System.out.println();
    }
}
