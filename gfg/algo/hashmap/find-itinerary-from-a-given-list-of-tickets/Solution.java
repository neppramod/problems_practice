import java.util.*;

public class Solution
{

    public static void printItinery(Map<String,String> map) {

        if (map != null) {
            HashMap<String,String> reverseMap = new HashMap<>();
            for (String key : map.keySet()) {
                reverseMap.put(map.get(key), key);
            }

            String start = "";
            for (String key : map.keySet()) {
                if (!reverseMap.containsKey(key)) {
                    start = key;
                }
            }

            if (start.length() > 0) {
                String key = start;
                while (key != null) {
                    String value = map.get(key);
                    if (value == null) break;
                    System.out.print(key + " -> " + map.get(key) + ", ");

                    key = map.get(key);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");

        printItinery(dataSet);

    }
}
