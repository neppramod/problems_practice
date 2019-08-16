import java.util.*;

public class Solution3
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
        BFSData sourceData = new BFSData(startWord);
        BFSData destData = new BFSData(stopWord);

        while (!sourceData.isFinished() && !destData.isFinished()) {
            // search from source
            String collision = searchLevel(wildCardLinkedGroup, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision);
            }

            // search from destination
            collision = searchLevel(wildCardLinkedGroup, destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision);
            }
        }

        return null;
    }

    private static String searchLevel(WildCardLinkedGroup wildCardLinkedGroup, BFSData primary, BFSData secondary)
    {
        // only search one level
        int count = primary.toVisit.size();
        for (int i = 0; i < count; i++) {

            // pull out first node
            PathNode pathNode = primary.toVisit.poll();
            String pathString = pathNode.getWord();

            // check if it's already been visited
            if (secondary.visited.containsKey(pathString)) {
                return pathNode.getWord();
            }



            // Add neighbors to queue
            ArrayList<String> validWords = getValidWords(pathString, wildCardLinkedGroup);
            for (String word : validWords) {
                if (!primary.visited.containsKey(word)) {
                    PathNode next = new PathNode(word, pathNode);
                    primary.visited.put(word, next);
                    primary.toVisit.add(next);
                }
            }
        }

        return null;
    }

    private static LinkedList<String> mergePaths(BFSData bfs1, BFSData bfs2, String connection)
    {
        PathNode end1 = bfs1.visited.get(connection);  // end1 -> source
        PathNode end2 = bfs2.visited.get(connection);  // end2 -> dest
        LinkedList<String> pathOne = end1.collapse(false);  // forward
        LinkedList<String> pathTwo = end2.collapse(true);   // reverse
        pathTwo.removeFirst(); // remove connection
        pathOne.addAll(pathTwo);
        return pathOne;
    }

    private static class BFSData
    {
        public Queue<PathNode> toVisit = new LinkedList<PathNode>();
        public HashMap<String, PathNode> visited= new HashMap<String, PathNode>();

        public BFSData(String root) {
            PathNode sourcePath= new PathNode(root, null);
            toVisit.add(sourcePath);
            visited.put(root, sourcePath);
        }

        public boolean isFinished()
        {
            return toVisit.isEmpty();
        }
    }

    private static class PathNode
    {
        private String word = null;
        private PathNode previous = null;

        public PathNode(String word, PathNode previous)
        {
            this.word = word;
            this.previous = previous;
        }

        public String getWord() { return word;}

        public LinkedList<String> collapse(boolean startsWithRoot)
        {
            LinkedList<String> path = new LinkedList<>();
            PathNode pathNode = this;

            while(pathNode != null) {
                if(startsWithRoot) {
                    path.addLast(pathNode.word);
                } else {
                    path.addFirst(pathNode.word);
                }
                pathNode = pathNode.previous;
            }

            return path;
        }
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
