import java.util.*;

public class ImageDithering
{
    public int count(String dithered, String[] screen)
    {
        int count = 0;

        HashMap<String, Integer> colorMap = new HashMap<>();
        createMap(colorMap, dithered);

        for (String sc : screen) {
            fillMap(colorMap, sc);
        }

        return sumColors(colorMap);
    }

    private void createMap(HashMap<String, Integer> map, String dithered)
    {
        for (int i = 0; i < dithered.length(); i++) {
            map.put(dithered.charAt(i) + "", 0);
        }
    }

    private void fillMap(HashMap<String, Integer> map, String line)
    {
        String[] lineCharStr = line.split("");

        for (String linec : lineCharStr) {
            if (map.containsKey(linec)) {
                map.put(linec, map.get(linec) + 1);
            }
        }
    }

    private int sumColors(HashMap<String, Integer> map)
    {
        int sum = 0;

        for (String key : map.keySet()) {
            sum += map.get(key);
        }

        return sum;
    }

    public static void main(String[] args)
    {
        ImageDithering id = new ImageDithering();
        String dither = "BW";
        String[] screen = {"AAAAAAAA",
                           "ABWBWBWA",
                           "AWBWBWBA",
                           "ABWBWBWA",
                           "AWBWBWBA",
                           "AAAAAAAA"};
        System.out.println(id.count(dither, screen));
    }
}
