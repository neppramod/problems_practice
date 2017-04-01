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
                allsets = getSubsets(set, index + 1);  // set, 1, index = 0, allsets =[{}, {3}, {2}, {3,2}]
                int item = set.get(index);             // index(0) = 1

                ArrayList<ArrayList<Integer>> moreset = new ArrayList<>(); // moreset = [{}]


                for (ArrayList<Integer> subset : allsets) { //
                    // 1st loop
                    // {}
                    ArrayList<Integer> newset = new ArrayList<>();
                    newset.addAll(subset); // {}
                    newset.add(item);      // {1}
                    moreset.add(newset);   // [{1}]

                    // 2nd loop
                    // {3}
                    // newset.addAll(subset) // {3}
                    // newset.add(item)      // {3,1}
                    // moreset.add(newset)   // [{1}, {3,1}]

                    // 3rd loop
                    // {2}
                    // newset.addAll(subset) // {2}
                    // newset.add(item)      // {2,1}
                    // moreset.add(newset)   // [{1}, {3,1}, {2,1}]

                    // 4th loop
                    // {3,2}
                    // newset.addAll(subset) // {3,2}
                    // moreset.add(item)     // {3,2,1}
                    // moreset.add(newset)   // [{1}, {3,1}, {2,1}, {3,2,1}]


                }

                allsets.addAll(moreset);   // [{}, {3}, {2}, {3, 2}, {1}, {3,1}, {2,1}, {3,2,1}]
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
