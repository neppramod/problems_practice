import java.util.*;

public class PowerSetIterative
{
    static ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> set)
    {
        ArrayList<ArrayList<Integer>> allsets = new ArrayList<>();
        allsets.add(new ArrayList<>());

        for (int i = 0; i < set.size(); i++) {
            Integer element = set.get(i);
            ArrayList<ArrayList<Integer>> moreset = new ArrayList<>();            
            for (List<Integer> sts : allsets) {
                ArrayList<Integer> collect = new ArrayList<>();
                collect.addAll(sts);
                collect.add(element);
                moreset.add(collect);
            }
            allsets.addAll(moreset);
        }
        
        return allsets;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> set = new ArrayList<>(Arrays.asList(1,2,3));
	for (ArrayList<Integer> s : getAllSubsets(set)) {
	    System.out.print(s);
	}
    }
}
