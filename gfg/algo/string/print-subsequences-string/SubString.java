import java.util.*;

public class SubString
{
    static void printAllSubString(String str, int n, String cur, int curIndex)
    {
        if (curIndex == n) {
            return;
        }

        System.out.println(cur);

        for (int i = curIndex + 1; i < n; i++) {
            printAllSubString(str, n, cur + str.charAt(i), i);
        }
    }

    public static void main(String[] args) {
        String str = "cab";
        printAllSubString(str, str.length(), "", -1);
    }
}
