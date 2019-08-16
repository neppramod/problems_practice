import java.util.*;

public class Solution2
{
    public static void main(String[] args)
    {
        String[] words = {"DAMP", "LAMP", "LIMP", "LIME", "LIKE"};
        String startWord = "DAMP";
        String stopWord = "LIKE";

        System.out.println(transform(startWord, stopWord, words));
    }

    public static LinkedList<String> transform(String startWord, String stopWord, String[] words)
    {
        WildCardLinkedGroup wildCardLinkedGroup = getWildCardLinkedGroup(words);
        ArrayList<String> visited = new ArrayList<>();

        return transform(startWord, stopWord, visited, wildCardLinkedGroup);
    }

    public static LinkedList<String> transform(String startWord, String stopWord, ArrayList<String> visited, WildCardLinkedGroup wildCardLinkedGroup)
    {
        if (startWord.equals(stopWord)) {
            LinkedList<String> path = new LinkedList<>();
            path.add(startWord);
            return path;
        } else if (visited.contains(startWord)) {
            return null;
        }

        visited.add(startWord);
r        ArrayList<String> matchingWords = getValidWords(startWord, wildCardLinkedGroup);
        for (String matchingWord : matchingWords) {
            LinkedList<String> path = transform(matchingWord, stopWord, visited, wildCardLinkedGroup);
            if (path != null) {
                path.addFirst(matchingWord);
                return path;
            }
        }

        return null;
    }

    private static ArrayList<String> getValidWords(String startWord, WildCardLinkedGroup wildCardLinkedGroup)
    {
        ArrayList<String> validWords = new ArrayList<>();
        ArrayList<String> wildCardRoots = getWildCardRoots(startWord);
        for (String wildCardRoot : wildCardRoots) {
            ArrayList<String> mappedWords = wildCardLinkedGroup.getMappedWords(wildCardRoot);
            for (String mappedWord : mappedWords) {
                if (!mappedWord.equals(startWord)) {
                    validWords.add(mappedWord);
                }
            }
        }

        return validWords;
    }

    private static WildCardLinkedGroup getWildCardLinkedGroup(String[] words)
    {
        WildCardLinkedGroup wildCardLinkedGroup = new WildCardLinkedGroup();
        for (String word : words) {
            ArrayList<String> wildCardRoots = getWildCardRoots(word);
            for (String wildCardRoot : wildCardRoots) {
                wildCardLinkedGroup.addWord(wildCardRoot, word);
            }
        }

        return wildCardLinkedGroup;
    }

    private static ArrayList<String> getWildCardRoots(String word)
    {
        if (word == null || word.length() == 0) {
            System.out.println("Input word null/blank");
            return null;
        }

        ArrayList<String> wildCardRoots = new ArrayList<>();
        for (int i  = 0; i < word.length(); i++) {
            String w = word.substring(0, i) + "_" + word.substring(i+1);
            wildCardRoots.add(w);
        }

        return wildCardRoots;
    }

    private static class WildCardLinkedGroup
    {
        private HashMap<String, ArrayList<String>> wildCardLinkedList = new HashMap<>();

        public void addWord(String wildCard, String word)
        {
            if (!wildCardLinkedList.containsKey(wildCard)) {
                wildCardLinkedList.put(wildCard, new ArrayList<>());
            }
            wildCardLinkedList.get(wildCard).add(word);
        }

        // return clone of the object
        public ArrayList<String> getMappedWords(String wildCard)
        {
            ArrayList<String> wildCardMappedWords = wildCardLinkedList.get(wildCard);
            if (wildCardMappedWords != null) return (ArrayList<String> )wildCardMappedWords.clone();
            else return null;
        }
    }
}
