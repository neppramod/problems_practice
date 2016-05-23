package myprob;

import java.util.*;

public class NoOfCuts
{
	public static void countSticks(Map<Integer, Integer> sticks)
	{
		ArrayList<Integer> keys = new ArrayList<>(sticks.keySet());
		Collections.sort(keys);
		
		while (keys.size() > 0) {
			int count = 0;
			
			for (Integer key : keys) {
				count += sticks.get(key);
			}
			
			System.out.println(count);
			keys.remove(0);
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Map<Integer, Integer> sticks = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			if (!sticks.containsKey(input)) {
				sticks.put(input, 1);
			} else {
				sticks.put(input, sticks.get(input) + 1);
			}
		}
		
		countSticks(sticks);
	}
}
