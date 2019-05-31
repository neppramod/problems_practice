import java.util.*;

public class AllSubset
{
    static ArrayList<ArrayList<Integer>> getSubsets(int[] arr, int index)
    {
        ArrayList<ArrayList<Integer>> allsubset;
        if (index == arr.length) {
            allsubset = new ArrayList<>();
            allsubset.add(new ArrayList<Integer>());
        } else {
            allsubset = getSubsets(arr, index + 1); // get subset list build till now
            int item = arr[index];

// loop through allsubset, and create new list and list of list that contains the previous elements of allsubset and new item

            ArrayList<ArrayList<Integer>> newsubset = new ArrayList<>();
            for (ArrayList<Integer> set : allsubset) {
                ArrayList<Integer> newset = new ArrayList<>();
                newset.addAll(set);   // copy all elements of current set
                newset.add(item);     // add array element
                newsubset.add(newset);   // add all newely built set to newely built set list
            }

// copy all the newely built sets to allsubset list, so that it contains not only previous elements used to build above new set, but also the new sets

            allsubset.addAll(newsubset);


        }

        return allsubset;

    }


    public static void main(String[] args)
    {
        int[] arr = {1,2,3};
        ArrayList<ArrayList<Integer>> allsubsets = getSubsets(arr, 0);
        for (ArrayList<Integer> list : allsubsets) {
            System.out.println(list);
        }
    }

}
