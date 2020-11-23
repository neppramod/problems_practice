package matrix.tictactoe;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class TicTacToeTest {

	@Test
	public void test3x3() {
		TicTacToe ticTacToe = new TicTacToe(3);
		ticTacToe.move(0, 0, 1);
		ticTacToe.move(0, 1, 2);
		ticTacToe.move(1, 1, 1);
		ticTacToe.move(0, 2, 2);
		int winner = ticTacToe.move(2, 2, 1);
		assertThat(winner, is(1));
	}
}
