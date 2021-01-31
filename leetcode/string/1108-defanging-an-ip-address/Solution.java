import java.util.*;

public class Solution {

    public static void main(String[] args) {

        String address = "255.100.50.0";
        String result = defangIPaddr(address);
        System.out.println(result);
    }

    public static String defangIPaddr(String address) {
        if (address == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : address.toCharArray()) {
                if (c == '.') {
                    sb.append("[.]");
                } else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }
}
