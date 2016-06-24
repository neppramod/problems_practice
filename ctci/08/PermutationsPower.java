import java.util.*;

public class PermutationsPower
{
    ArrayList<ArrayList<String>> powerSet(ArrayList<String> orig)
    {
        ArrayList<ArrayList<String>> allset;

        if (orig.size() == 0) {
            allset = new ArrayList<>();
            allset.add(new ArrayList<String>());
            return allset;
        } else {
            String element = orig.remove(0);
            allset = powerSet(orig);
            ArrayList<ArrayList<String>> newSet = new ArrayList<>();

            for (ArrayList<String> list : allset) {
                ArrayList<String> mylist = new ArrayList<>();
                for (String s : list) {
                    mylist.add(s);                    
                }
                mylist.add(element);
                newSet.add(mylist);
            }

            allset.addAll(newSet);
            return allset;
        }
        
        
    }

    public static void main(String[] args)
    {
        PermutationsPower perm = new PermutationsPower();
        ArrayList<String> set = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
        for (ArrayList<String> p : perm.powerSet(set)) {
            System.out.println(p);
        }
    }
}

