import java.util.*;

public class CoinPiles {
    public static void main(String[] args) {
	    CoinPiles sol = new CoinPiles();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();

			long mx = Math.max(a, b);
			long mi = Math.min(a, b);

			long diff = mx - mi;

			mx -= 2 * diff;
			mi -= diff;
			StringBuilder sb = new StringBuilder();

			if (mi == 0 || (mi > 0 && mi % 3 == 0)) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}

			System.out.println(sb);
		}
	}
	
    
}
