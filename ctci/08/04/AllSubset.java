import java.util.*;

public class AllSubset
{
    static ArrayList<ArrayList<Integer>> getAllSubset(ArrayList<Integer> set, int index)
    {
        ArrayList<ArrayList<Integer>> allSubset;
        if (index == -1) {
            allSubset = new ArrayList<>();
            allSubset.add(new ArrayList<Integer>());
        } else {

        allSubset = getAllSubset(set, index-1);
        int item = set.get(index);

        ArrayList<ArrayList<Integer>> moreSubset = new ArrayList<>();
        for (ArrayList<Integer> subset : allSubset) {
            ArrayList<Integer> newsubset = new ArrayList<>();
            newsubset.addAll(subset);
            newsubset.add(set.get(index));
            moreSubset.add(newsubset);
        }
        allSubset.addAll(moreSubset);
        }
        return allSubset;
    }

    static ArrayList<ArrayList<Integer>> getAllSubset(ArrayList<Integer> set, ArrayList<Integer> prefix) {
        if (prefix.length() == set.length()) {

        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);

        for (ArrayList<Integer> s1 : getAllSubset(set, set.size() - 1)) {
            System.out.print("(");
            for (Integer s : s1) {
                System.out.print(s + ",");
            }
            System.out.println(")");
        }
    }
}
