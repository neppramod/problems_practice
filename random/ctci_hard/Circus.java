import java.util.*;

/*
  Strictly smaller wt,length person can be on top of a tower construction in circus,
  count max number of people that can form such tower
 */

public class Circus
{
    private static class Person
    {
        int weight;
        int height;

        public int getWeight() { return weight; }
        public int getHeight() { return height; }

        public Person(int wt, int ht) { weight = wt; height = ht; }
        public boolean canBeAbove(Person p1) {
            if (p1 == null) return true;
            return weight <= p1.getWeight() && height <= p1.getHeight();
        }
    }

    private static class PersonComparator implements Comparator<Person>
    {
        public int compare(Person p1, Person p2)
        {
            int height = p2.height - p1.height;  // descending order
            if (height != 0) return height;
            else
                return p2.weight - p1.weight;
        }
    }

    public static void main(String[] args)
    {
        int[] heights = new int[] {5, 3, 8, 4, 9};
        int[] weights = new int[] {12, 11, 12, 12, 8};
        List<Person> people = createPeople(heights, weights);
        Collections.sort(people, new PersonComparator());
        int count = createStack(people);
        System.out.println("Count: " + count);
    }

    static int createStack(List<Person> people)
    {
        int N = people.size();
        int[] memo = new int[N];  // initialized to 0
        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            int curCount = createStack(people, i, memo);
            maxCount = Math.max(curCount, maxCount);
        }

        return maxCount;
    }

    static int createStack(List<Person> people, int curIndex, int[] memo)
    {
        if (curIndex >= people.size()) return 0; // we are done
        if (memo[curIndex] > 0) return memo[curIndex];
        int N = people.size();

        int maxCount = 0;
        Person personAtBottom = people.get(curIndex);
        for (int i = curIndex + 1; i < N; i++) {
            Person curPerson = people.get(i);
            if (curPerson.canBeAbove(personAtBottom)) {
                int count = createStack(people, i, memo);
                maxCount = Math.max(count, maxCount);
            }
        }

        return maxCount + 1; // for currentIndex
    }

    static List<Person> createPeople(int[] heights, int[] weights)
    {
        int N = heights.length;
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new Person(weights[i], heights[i]));
        }

        return list;
    }
}
