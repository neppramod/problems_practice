import java.util.*;

public class PoorPigs {
    public static void main(String[] args) {
	    PoorPigs sol = new PoorPigs();
		System.out.println(sol.poorPigs(4, 15, 15));
	}
	
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		int T = minutesToTest / minutesToDie;
		int x = 0;

		while ((int)Math.pow(T + 1, x) < buckets) {
			x++;
		}

		return x;
        
    }
}
