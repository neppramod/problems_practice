import java.util.*;

class PowerSet
{

    static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set)
    {
	return getSubsets(set, 0);
    }
    
    static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index)
    {
	ArrayList<ArrayList<Integer>> allsets;

	if (index == set.size()) {
	    allsets = new ArrayList<>();
	    allsets.add(new ArrayList<Integer>());
	} else {
	    allsets = getSubsets(set, index + 1);
	    int item = set.get(index);
	    
	    ArrayList<ArrayList<Integer>> moreset = new ArrayList<>();
	    for (ArrayList<Integer> subset : allsets) {
		ArrayList<Integer> newset = new ArrayList<>();
		newset.addAll(subset);
		newset.add(item);
		moreset.add(newset);
	    }

	    allsets.addAll(moreset);
	}

	return allsets;
    }

    public static void main(String[] args)
    {
	ArrayList<Integer> set = new ArrayList<>(Arrays.asList(1,2,3));
	for (ArrayList<Integer> s : getSubsets(set)) {
	    System.out.print(s);
	}
    }
}
