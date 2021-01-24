import java.util.*;

public class GrayCode {
    public static void main(String[] args) {
	    GrayCode sol = new GrayCode();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sol.printGrayCode(n);
	}

	// i xor (i/2) gives gray code
	// 00 xor 00 = 00
	// 01 xor 00 = 01
	// 10 xor 01 = 11
	// 11 xor 01 = 10
	// 0, 1, 3, 2
    public void printGrayCode(int n) {
		int limit = (int)Math.pow(2, n);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < limit; i++) {
			StringBuilder sb1 = new StringBuilder(Integer.toString(i ^ (i>>1), 2));
			while (sb1.length() < n) {
				sb1.insert(0, "0");
			}
			sb1.append("\n");
			sb.append(sb1);
		}

		System.out.println(sb);
	}
}
