import java.util.*;

public class NumberOfTimes
{
    public static void main(String[] args)
    {
        Map<String,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            if (!map.containsKey(s)) {
                map.put(s,1);
            } else {
                map.put(s, map.get(s)+1);
            }
        }

        for (String s : map.keySet()) {
            System.out.print(s + " : " + map.get(s) + " , ");
        }
    }
}
