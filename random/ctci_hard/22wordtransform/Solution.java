import java.util.*;
/*
  Word transform: Convert one word to another, each character at a time, given the transformed word is also in dictionary
 */
public class Solution
{
    public static LinkedList<String> transform(String startWord, String stopWord, String[] words)
    {
        HashSet<String> dictionary = createDictionary(words);
        HashSet<String> visited = new HashSet<>();
        return transform(startWord, stopWord, dictionary, visited);
    }

    private static HashSet<String> createDictionary(String[] words)
    {
        HashSet<String> dictionary = new HashSet<>();
        for (String word : words) {
            dictionary.add(word);
        }

        return dictionary;
    }

    private static LinkedList<String> transform(String startWord, String stopWord, HashSet<String> dictionary, HashSet<String> visited)
    {
        if (startWord.equals(stopWord)) {
            LinkedList<String> path = new LinkedList<>();
            path.add(startWord);
            return path;
        } else if (visited.contains(startWord) || !dictionary.contains(startWord)) {
            return null;
        }


        visited.add(startWord);
        ArrayList<String> oneOffWords = oneOffWords(startWord);
        for (String oneOffWord : oneOffWords) {
            LinkedList<String> path = transform(oneOffWord, stopWord, dictionary, visited);
            if (path != null) { path.addFirst(startWord); return path;}
        }

        return null;
    }

    private static ArrayList<String> oneOffWords(String startWord)
    {
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < startWord.length(); i++) {
            for (char c = 'A'; c <= 'Z'; c++) {
                String word = startWord.substring(0,i) + c + startWord.substring(i+1);
                words.add(word);
            }
        }

        return words;
    }

    public static void main(String[] args)
    {
        String[] words = {"DAMP", "LAMP", "LIMP", "LIME", "LIKE"};
        String startWord = "DAMP";
        String stopWord = "LIKE";
        LinkedList<String> transformPath = transform(startWord, stopWord, words);
        System.out.println(transformPath);
    }

}
