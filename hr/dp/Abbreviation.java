import java.util.*;

public class Abbreviation
{
    static boolean abbreviation(String a, String b)
    {
        if (a.length() == 0 && b.length() == 0) return true;
        if (a.length() < b.length()) return false;
        if (a.length() > 0 && b.length() == 0) {
            for (int i = 0; i < a.length(); i++) {
                if (Character.isUpperCase(a.charAt(i))) return false;
            }
            return true;
        }


        if (a.charAt(0) == b.charAt(0) || Character.toUpperCase(a.charAt(0)) == b.charAt(0))
            return abbreviation(a.substring(1), b.substring(1));
        else {
            return abbreviation(a.substring(1), b);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- >0) {
        String a = sc.next();
        String b = sc.next();
        System.out.println(abbreviation(a, b)?"YES":"NO");
        }
    }
}
