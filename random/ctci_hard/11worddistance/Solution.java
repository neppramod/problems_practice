import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        String sentence = "there are apple and orange in the garden there are also apple and orange in market";
        String[] words = sentence.split(" ");
        int minDist = minDist(words, "garden", "in");
        System.out.println("min distance : " + minDist);

    }

    private static int minDist(String[] words, String word1, String word2)
    {
        HashMap<String, ArrayList<Integer>> map = buildMap(words);
        ArrayList<Integer> array1 = map.get(word1);
        ArrayList<Integer> array2 = map.get(word2);

        return minDist(array1, array2);
    }

    private static int minDist(ArrayList<Integer> array1, ArrayList<Integer> array2)
    {
        int i = 0, j = 0;
        int mindistance = Integer.MAX_VALUE;

        while (i < array1.size() && j < array2.size()) {
            int curDist = Math.abs(array1.get(i) - array2.get(j));
            if (curDist < mindistance) mindistance = curDist;

            if (array1.get(i) < array2.get(j))
                i++;
            else
                j++;
        }

        return mindistance;
    }

    static HashMap<String, ArrayList<Integer>> buildMap(String[] words)
    {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            } else {
                ArrayList<Integer> list = map.get(words[i]);
                list.add(i); // will save back to same reference
            }
        }

        return map;
    }

}
