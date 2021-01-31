import java.util.*;

public class OddEvenJump {
    public static void main(String[] args) {
	    OddEvenJump sol = new OddEvenJump();
		Scanner sc = new Scanner(System.in);
		int[] A = {10, 13, 12, 14, 15};
		System.out.println(sol.oddEvenJumps(A));
	}
	
    // We use TreeMap and value from hi, lo
	// of ceil for hi, floor for lo, and pick value from alternate
	// heigher and lower
	public int oddEvenJumps(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		int n = A.length;
		boolean[] higher = new boolean[n];
		boolean[] lower = new boolean[n];
		int count = 1;
		higher[n-1] = true;
		lower[n-1] = true;
		treeMap.put(A[n-1], n-1);
		
		for (int i = n-2; i >= 0; i--) {
			Map.Entry<Integer, Integer> hi = treeMap.ceilingEntry(A[i]);
			Map.Entry<Integer, Integer> lo = treeMap.floorEntry(A[i]);

			if (hi != null) {
				higher[i] = lower[hi.getValue()];
			}

			if (lo != null) {
				lower[i] = higher[lo.getValue()];
			}

			if (higher[i]) {
				count++;
			}

			treeMap.put(A[i], i);
		}

		return count;
    }
}
