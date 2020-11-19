package manhattan;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;


public class BestMeetingPointTest {

	@Test
	public void testMinTotalDistance() {
		/*	
		Manhattan Distance, distance(p1, p2) = |p2.x-p1.x| + |p2.y-p1.y|
		
		1-0-0-0-1
		| | | | |
		0-0-0-0-0
		| | | | |
		0-0-1-0-0
		
		cols = [0, 2, 4]
		rows = [0, 0, 2]
		
		sum = 0
		
		row = 0, sum = 0-0
		row = 0, sum = 0 - 0
		row = 4, sum = 2 - 0 = 2
		
		cols = [0, 2, 4]
		
		col = 0, sum = 0 - 2 => 2, sum = 2 + 2 = 4
		col = 2, sum = 2 - 2 => 0, sum = 4
		col = 4, sum = 4 - 2 => 2, sum = 4 + 2 = 6
				
		 */

		int[][] grid = new int[3][5];
		grid[0][0] = 1;
		grid[0][4] = 1;
		grid[2][2] = 1;

		BestMeetingPoint bestMeetingPoint = new BestMeetingPoint();
		assertThat(bestMeetingPoint.minTotalDistance(grid), is(6));
	}
}
