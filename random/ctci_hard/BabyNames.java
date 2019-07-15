import java.util.*;
import static java.util.Map.*;

public class BabyNames
{

    private static class NameSet
    {
        HashSet<String> names = new HashSet<>();
        int frequency = 0;
        String rootName;

        public NameSet(String name, int freq)
        {
            names.add(name);
            rootName = name;
            frequency = freq;
        }

        public HashSet<String> getNames() { return names; }
        public int getFrequency() { return frequency; }
        public String getRootName() { return rootName; }
        public int getSize() { return names.size(); }

        public void addNamesWithFreq(HashSet<String> names, int freq)
        {
            this.names.addAll(names);
            frequency += freq;
        }

        public String toString()
        {
            return rootName + ": " + frequency + ", " + names.toString();
        }
    }



    // Map <String,Int> to <String, NameSet> groups;
    // merge groups that match synonyms
    // return back map with frequency

    public static void main(String[] args)
    {
        HashMap<String, Integer> nameFreq = new HashMap<>();
        String[][] synonyms = new String[][] {{"Jonathan", "John"}, {"Jon", "Johnny"},
                                              {"Johnny", "John"}, {"Kari", "Carrie"}, {"Carleton", "Carlton"}};

        nameFreq.put("John", 10);
        nameFreq.put("Jon", 3);
        nameFreq.put("Davis", 2);
        nameFreq.put("Kari", 3);
        nameFreq.put("Johnny", 11);
        nameFreq.put("Carlton", 8);
        nameFreq.put("Carleton", 2);
        nameFreq.put("Jonathan", 9);
        nameFreq.put("Carrie", 5);



        HashMap<String, NameSet> groups = createGroup(nameFreq);
        combineGroups(groups, synonyms);

        // print groups

        // for (String groupKey : groups.keySet()) {
        // System.out.println(groups.get(groupKey));
        // }

        HashMap<String, Integer> finalMap = buildMap(groups);

        for (String name : finalMap.keySet()) {
            System.out.println(name + ": " + finalMap.get(name));
        }
    }

    // groups = {John => 10, Jon => 3, Davis => 2, Kari => 3, Johnny => 11, Carlton => 8 ...}
    private static HashMap<String, NameSet> createGroup(HashMap<String, Integer> nameFreq)
    {
        HashMap<String, NameSet> groups = new HashMap<>();
        for (Entry<String,Integer> entry : nameFreq.entrySet())
        {
            groups.put(entry.getKey(), new NameSet(entry.getKey(), entry.getValue()));
        }

        return groups;
    }

/*
  {{"Jonathan", "John"}, {"Jon", "Johnny"},
  {"Johnny", "John"}, {"Kari", "Carrie"}, {"Carleton", "Carlton"}};
 */
    private static void combineGroups(HashMap<String, NameSet> groups, String[][] synonyms)
    {
        for (String[] synonym: synonyms) {
            NameSet set1 = groups.get(synonym[0]);
            NameSet set2 = groups.get(synonym[1]);

            if (set1 == null || set2 == null || set1 == set2) continue;

            NameSet bigger = set1.getSize() > set2.getSize() ? set1 : set2;
            NameSet smaller = set1.getSize() > set2.getSize() ? set2 : set1;

            bigger.addNamesWithFreq(smaller.getNames(), smaller.getFrequency());

            for (String name : smaller.getNames()) {
                groups.put(name, bigger); // all point to same set
            }
        }
    }

    private static HashMap<String, Integer> buildMap(HashMap<String, NameSet> groups)
    {
        HashMap<String, Integer> map = new HashMap<>();
        for (Entry<String,NameSet> entry : groups.entrySet()) {
            NameSet set = entry.getValue();
            map.put(set.getRootName(), set.getFrequency());
        }
        return map;
    }
}
