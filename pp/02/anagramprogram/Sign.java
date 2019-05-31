import java.util.*;

public class Sign
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String word = sc.next();
            String key = sortStr(word);
            System.out.printf("%s %s\n", key, word);
        }
    }

    private static String sortStr(String input)
    {
        char[] tmpArray = input.toCharArray();
        Arrays.sort(tmpArray);
        return new String(tmpArray);
    }
}
