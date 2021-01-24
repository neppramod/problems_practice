import java.util.*;


public class TowerOfHanoi {

	static int moves = 0;
	
    public static void main(String[] args) {
	    TowerOfHanoi sol = new TowerOfHanoi();
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sol.move(i, 1, 3, 2, sb);

		System.out.println(moves);
		System.out.println(sb);
	}
	
    void move(int disk, int src, int dest, int using, StringBuilder sb) {
		if (disk == 1) {
			//System.out.println(src + " " + dest);
			sb.append(src + " " + dest + "\n");
			moves++;
		} else {
			move(disk-1, src, using, dest, sb);
			sb.append(src + " " + dest + "\n");
			moves++;
			move(disk-1, using, dest, src, sb);
		}
	}
}
