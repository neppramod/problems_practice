import java.util.*;

public class MergeArrays
{
	public ArrayList<String> merge(String[] words, String[] more)
	{
		ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(words));
		wordList.addAll(Arrays.asList(more));
		return wordList;
	}
	
	public static void main(String[] args) {	
		ArrayList<String> myList = new MergeArrays().merge(new String[] {"A", "p", "p"}, 
			new String[] {"l", "e"});
		System.out.println(myList);
	}
}
