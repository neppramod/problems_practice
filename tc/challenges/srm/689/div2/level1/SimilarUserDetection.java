import java.util.*;

public class SimilarUserDetection
{
    public String haveSimilar(String[] handles)
    {
        HashMap<String,Integer> map = new HashMap<>();

        for (String h : handles) {
            if (h == null || h.length() == 0) {
		continue;
            }

            String conv = convert(h);

            if (map.containsKey(conv)) {
                return "Similar handles found";
            } else {
                map.put(conv, 0);
            }
        }

        return "Similar handles not found";
    }

    private String convert(String str)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '0') {
                ch = 'O';
            } else if (ch == '1' || ch == 'l') {
                ch = 'I';
            }

            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        SimilarUserDetection sd = new SimilarUserDetection();
        System.out.println(sd.haveSimilar(new String[] {"TOPCODER", "top", "coder", "TOPCADER"}));
    }
}
