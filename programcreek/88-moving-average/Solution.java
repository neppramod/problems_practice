import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
        MovingAverage av = new MovingAverage(2);
		System.out.println(av.next(3));
		System.out.println(av.next(4));
		System.out.println(av.next(8));
		System.out.println(av.next(6));
    }
    
    static class MovingAverage
	{
		double sum = 0;
		int size;
		LinkedList<Integer> list;

		public MovingAverage(int size) {
			this.size = size;
			list = new LinkedList<>();
		}

		double next(int val) {
			sum += val;
			list.add(val);

			if (list.size() <= size) {
				return sum / list.size();
			}

			sum -= list.poll();
			return sum/size;
		}
	}
}
