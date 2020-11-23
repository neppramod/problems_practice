package matrix.gameoflife;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class GameOfLifeTest {

	@Test
	public void testGameOfLife()  {
		GameOfLife gameOfLife = new GameOfLife();
		int[][] board = {{1, 0, 1, 1, 1},
						 {0, 0, 1, 0, 0},
						 {0, 1, 1, 1, 1},
						 { 0, 0, 0, 0, 1 } };
		gameOfLife.gameOfLife(board);
		
		int[][] expectedResult = 
		{{0, 1, 1, 1, 0},
		 {0, 0, 0, 0, 0},
		 {0, 1, 1, 0, 1},
		 {0, 0, 1, 0, 1}};

		
		assertThat(board, is(expectedResult));
	}
}
