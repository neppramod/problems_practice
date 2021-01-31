import java.util.*;
 
public class GridPaths {
    public static void main(String[] args) {
	    GridPaths sol = new GridPaths();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		long time = System.currentTimeMillis();
		int result = sol.countPaths(s);
		System.out.println(result);
		long diff = System.currentTimeMillis() - time;
		System.out.println("Diff: " + (diff / 1000));
	}
	
    static int count = 0;
	static boolean[][] visited = new boolean[7][7];
	
	int countPaths(String input) {
		char[] s = input.toCharArray();

		dfs(0, 0, 0);
		
		return count;
	}


	void dfs(int i, int j, char[] s, int steps) {
		if (i == 6 && j == 0) {
			if (steps == 48) {
				count++;
			}

			return;
		}

				visited[i][j] = true;
	}

}
