import java.util.*;

public class Urlify03
{
    public static String urlify(String str, int len)
    {
        char[] cstr = str.toCharArray();
        int back = str.length() - 1;
        int front = len - 1;

        while (front >= 0 || back >= 0) {
            if (back < front)
                return null;

            if (cstr[front] == ' ') {
                if (back - 2 >= 0) {
                    cstr[back] = '0';
                    cstr[back - 1] = '2';
                    cstr[back - 2] = '%';
                    back -= 3;
                }
            } else {
                cstr[back] = cstr[front];
                back--;
            }

            front--;
        }
    

        StringBuilder sb = new StringBuilder();
        for (int i = front + 1; i < str.length(); i++) {
            sb.append(cstr[i]);
        }
 
        return sb.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(urlify("Mr John Smith    ", 13));
    }
}
