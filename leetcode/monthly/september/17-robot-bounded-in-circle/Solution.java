import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		String input = "GGLLGG";
		boolean result = sol.isRobotBounded(input);
		System.out.println(result);
    }
    
    public boolean isRobotBounded(String instructions) {
		if (instructions == null || instructions.length() == 0) {
			return false;
		}

		char direction = 'N';
		int x = 0, y = 0;  // y up, x right
		
		for (char c : instructions.toCharArray()) {
			if (c == 'G') {
				switch (direction) {
				case 'N':
					y++;
					break;
				case 'S':
					y--;
					break;
				case 'E':
					x++;
					break;
				default:
					x--;
					break;
				}
			} else if (c == 'L') {
				switch(direction) {
				case 'N':
					direction = 'W';
					break;
				case 'W':
					direction = 'S';
					break;
				case 'S':
					direction = 'E';
					break;
				default:
					direction = 'N';
					break;
				}
			} else if (c == 'R') {
				switch (direction) {
				case 'N':
					direction = 'E';
					break;
				case 'E':
					direction = 'S';
					break;
				case 'S':
					direction = 'W';
					break;
				default:
					direction = 'N';
					break;
				}
			}
		}

		return (x == 0 && y == 0) || (direction != 'N');
    }
}
