import java.util.*;

public class LengthOfShortestChain
{
    public int lengthOSC(ArrayList<String> dictionary, String start, String target)
    {
	int length = 1;
	String currentWord = "";
	Queue<String> queue = new LinkedList<>();
	ArrayList<String> similarWords = findSimilarWords(dictionary, start);
	queue.addAll(similarWords);
	dictionary.removeAll(similarWords);

	System.out.print(start + " - " );
	while (queue.size() > 0 && !currentWord.equals(target)) {
	    length++;
	    String curWord = queue.poll();
	    System.out.print(curWord + " - ");
	    ArrayList<String> simWords = findSimilarWords(dictionary, curWord);
	    queue.addAll(simWords);
	    dictionary.removeAll(simWords);
	}

	System.out.println();

	return length;
    }

    public ArrayList<String> findSimilarWords(List<String> formattedDictionary, String target) {
	ArrayList<String> matchedList = new ArrayList<>();
	
	for (String dictword : formattedDictionary) {
	    int matched = 0;

	    for (int i = 0; i < target.length(); i++) {
		if (target.charAt(i) == dictword.charAt(i)) {
		    matched++;
		}
	    }

	    if (matched == target.length() - 1) {
		matchedList.add(dictword);
	    }
	}

	return matchedList;
    }

    public static void main(String[] args) {
	ArrayList<String> dict = new ArrayList<>(Arrays.asList("POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"));
	LengthOfShortestChain lsc = new LengthOfShortestChain();
	
	System.out.println(lsc.lengthOSC(dict, "TOON", "PLEA"));
    }
}
