import java.util.*;

public class Solution
{
    public static void main(String[] args) {
	String s = "ababcbacadefegdehijhklij";
	List<Integer> result = getPartitionLabels(s);
	System.out.println(result);
    }

    static List<Integer> getPartitionLabels(String s) {

        List<Integer> outputList = new ArrayList<>();
	if (s == null || s.length() == 0) {
	    return outputList;
	}

	HashMap<Character, Pair> map = new HashMap<>();
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (!map.containsKey(c)) {
		map.put(c, new Pair(i, 0));
	    } else {
		Pair p = map.get(c);

		p.y = i;
		map.put(c, p);
	    }
	}

        System.out.println(map);

        List<Pair> list = new ArrayList<>();


        list.addAll(map.values());
        Collections.sort(list);

        Pair t = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Pair p = list.get(i);


            if (p.y <= t.y) {
                continue;
            } else if (p.x > t.y) {
                outputList.add(t.y - t.x + 1);
                t = p;
            } else {
                t.y = p.y;
            }
        }

        outputList.add(t.y - t.x + 1);


        return outputList;
    }

    static class Pair implements Comparable<Pair>
    {
	Integer x, y;
	public Pair(Integer x1, Integer y1) {
	    x = x1;
	    y = y1;
	}

	public String toString() {
	    return x + "," + y;
	}

        public int compareTo(Pair p) {
            if (x != p.x) {
                return x-p.x;
            } else {
                return y-p.y;
            }
        }
    }
}
