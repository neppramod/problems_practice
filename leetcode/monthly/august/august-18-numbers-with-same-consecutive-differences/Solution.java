import java.util.*;

public class Solution
{
	public static void main(String[] args) {
		Solution sol = new Solution();
		int N = 1;
		int K = 0;
		int[] anser = sol.numsSameConsecDiff(N, K);
		System.out.println(Arrays.toString(anser));
	}

	/* Numbers with Same consecutive differences.

	N = 3, K = 7

	[181, 292, 707, 818, 929]

	1 <= N <= 9
	0 <= K <= 9

I think we can use simple loop
	*/

	public int[] numsSameConsecDiff(int N, int K) {
		List<Integer> list = new ArrayList<>();

		int start = getLowest(N);
		int end = getHeighest(N);

		for (int i = start; i <= end; i++) {
			if (consecutiveDiff(i, K)) {
				list.add(i);
			}
		}

		return getArray(list);
	}

	int[] getArray(List<Integer> list) {
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

	int getLowest(int N) {
		if (N == 1) {
			return 0;
		}

		int answer = 1;
		while (N-1 > 0) {
			answer = answer * 10;
			N--;
		}

		return answer;
	}

	int getHeighest(int N) {
		int answer = 9;
		while (N-1 > 0) {
			answer = (answer * 10 + 9);
			N--;
		}

		return answer;
	}

	boolean consecutiveDiff(int num, int K) {
		String numVal = String.valueOf(num);
		char[] numArr = numVal.toCharArray();



		for (int i = 0; i < numArr.length-1; i++) {
			int curDiff = Math.abs(numArr[i+1] - numArr[i]);
			if (curDiff != K) {
				return false;
			}
		}

		return true;
	}


}
