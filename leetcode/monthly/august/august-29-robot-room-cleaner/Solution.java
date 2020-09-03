import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
         
    }
    
	public void cleanRoom(Robot robot) {
  
		HashSet<String> visited = new HashSet<>();
		cleanRoom(robot, 0, 0, 0, visited);
	}

	static int moves[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	interface Robot {
		// returns true if next cell is open and robot moves into the cell.
		// returns false if next cell is obstacle and robot stays on the current cell.
		boolean move();

		// Robot will stay on the same cell after calling turnLeft/turnRight.
		// Each turn will be 90 degrees.
		void turnLeft();
		void turnRight();

		// Clean the current cell.
		void clean();
	}
	
	private void cleanRoom(Robot robot, int x, int y, int dir, HashSet<String> visited) {
		robot.clean();
		//visited.add(new Pair(x, y));
        visited.add(x + " - " + y);
        
		for (int i = 0; i < 4; i++) {
			int cur = (i + dir) % 4;
			int nX = x + moves[cur][0];
			int nY = y + moves[cur][1];

			//Pair np = new Pair(nX, nY);
            String ns = nX + " - " + nY;

			if (!visited.contains(ns) && robot.move()) {
				cleanRoom(robot, nX, nY, cur, visited);
				robot.turnRight();
				robot.turnRight();
				robot.move();
				robot.turnLeft();
				robot.turnLeft();
			}

			robot.turnRight();
		}
		
	}
}
