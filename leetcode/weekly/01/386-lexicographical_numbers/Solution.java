import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
		int n = 13;
		Solution sol = new Solution();
		System.out.println(sol.lexicalOrder(n));
    }
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<Integer>();
		List<Number> numbers = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			numbers.add(new Number(i));
		}

		Collections.sort(numbers);

		for (Number n1 : numbers) {
			result.add(n1.number);
		}

		return result;
    }
    
    static class Number implements Comparable<Number>
    {
		int number;

		public Number(int n) {
			number = n;
		}

		public int compareTo(Number n) {
			return String.valueOf(number).compareTo(String.valueOf(n.number));
		}
    }
}
