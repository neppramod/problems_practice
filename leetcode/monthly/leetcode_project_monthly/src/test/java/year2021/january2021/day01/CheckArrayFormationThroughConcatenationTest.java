package year2021.january2021.day01;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class CheckArrayFormationThroughConcatenationTest {
	@Test
	public void testExample1() {
		int[] arr = { 85 };
		int[][] pieces = { { 85 } };
		CheckArrayFormationThroughConcatenation checkArrayFormationThroughConcatenation = new CheckArrayFormationThroughConcatenation();


		assertThat(checkArrayFormationThroughConcatenation.canFormArray(arr, pieces), is(true));
	}

	@Test
	public void testExample2() {
		int[] arr = {15,88};
		int[][] pieces ={{88}, {15}};
		CheckArrayFormationThroughConcatenation checkArrayFormationThroughConcatenation = new CheckArrayFormationThroughConcatenation();


		assertThat(checkArrayFormationThroughConcatenation.canFormArray(arr, pieces), is(true));
	}

		@Test
	public void testExample3() {
			int[] arr = {49, 18, 16};
			int[][] pieces ={{16, 18, 49}};
		CheckArrayFormationThroughConcatenation checkArrayFormationThroughConcatenation = new CheckArrayFormationThroughConcatenation();


		assertThat(checkArrayFormationThroughConcatenation.canFormArray(arr, pieces), is(false));
	}

	@Test
	public void testExample4() {
		int[] arr = {91,4,64,78};
		int[][] pieces = {{78}, {4, 64}, {91}};
		CheckArrayFormationThroughConcatenation checkArrayFormationThroughConcatenation = new CheckArrayFormationThroughConcatenation();


		assertThat(checkArrayFormationThroughConcatenation.canFormArray(arr, pieces), is(true));
	}


	@Test
	public void testExample5() {
		int[] arr = {1,3,5,7};
		int[][] pieces = {{2, 4, 6, 8}};
		CheckArrayFormationThroughConcatenation checkArrayFormationThroughConcatenation = new CheckArrayFormationThroughConcatenation();


		assertThat(checkArrayFormationThroughConcatenation.canFormArray(arr, pieces), is(false));
	}

	
}
