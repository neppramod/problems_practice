import java.util.*;

public class Permutations {
    public static void main(String[] args) {
	    Permutations sol = new Permutations();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sol.printPermutations(n);
	}
	
    public static void printPermutations(int n) {
		if (n == 1) {
			System.out.println("1");
		} else if (n <= 3) {
			System.out.println("NO SOLUTION");
		}else if (n == 4) {
			System.out.print("2 4 1 3");
		}else {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 1; i <= n; i += 2) {
				sb.append(i + " ");
				//System.out.print(i + " ");
			}

			for (int i = 2; i <= n; i+= 2) {
				//System.out.print(i + " ");
				sb.append(i + " ");
			}

			System.out.println(sb.toString());
		}
	}
}
