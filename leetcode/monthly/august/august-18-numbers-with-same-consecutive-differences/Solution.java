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

	Use dfs(N, K, list, curNumber):
	case1: N <= 0, add curNumber to list, return
	case 2:  i range from 0 to 10:
	   case a:	i == 0, curNumber == 0, continue (leading 0)
	   case b: i != 0, curNumber == 0, dfs(N-1, K, list, i);
	case c: Math.abs(curNumber % 10 - i) == K, dfs(N-1, K, list, curNumber * 10 + i);
	*/

	public int[] numsSameConsecDiff(int N, int K) {
		List<Integer> list = new ArrayList<>();

		if (N == 1) {
			list.add(0);
		}

		dfs(N, K, list, 0);
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}

		return arr;
	}

	void dfs(int N, int K, List<Integer> list, int curNumber) {
		if (N <= 0) {
			list.add(curNumber);
			return;
		} else {
			for (int i = 0; i < 10; i++) {
				if (i == 0 && curNumber == 0) {
					continue;
				} else if (i != 0 && curNumber == 0) {
					dfs(N - 1, K, list, i);
				} else if (Math.abs(curNumber % 10 - i) == K) {
					dfs(N - 1, K, list, curNumber * 10 + i);
				}
			}
		}
	}





}
