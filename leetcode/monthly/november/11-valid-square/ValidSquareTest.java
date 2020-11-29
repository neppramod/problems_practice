import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;



public class ValidSquareTest {

	@Test
	public void testValidSquare() {
		int[] p1 = { 0, 0 };
		int[] p2 = { 1, 1 };
		int[] p3 = { 1, 0 };
		int[] p4 = { 0, 1 };

		ValidSquare validSquare = new ValidSquare();
		assertThat(validSquare.validSquare(p1, p2, p3, p4), is(true));
	}
}
