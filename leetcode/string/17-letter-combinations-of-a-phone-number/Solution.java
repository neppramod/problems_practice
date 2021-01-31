import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String digits = "23";
        List<String> letterComb = letterCombinations(digits);
        System.out.println(letterComb);

    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        } else {
            char[] ds = digits.toCharArray();
            int n = ds.length;
            List<String> strList = new ArrayList<>();
            createList(strList, ds, map, 0, "");
            return strList;
        }
    }

    static void createList(List<String> strList, char[] ds, HashMap<Character, List<Character>> map, int di, String s) {
        if (di == ds.length) {
            strList.add(s);
            return;
        } else {
            List<Character> curList = map.get(ds[di]);
            for (char c : curList) {
                createList(strList, ds, map, di + 1, s + c);
            }
        }
    }

    static void pA1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pA1(arr[i]);
        }
    }
}
