import java.util.*;

public class FlippingAnImageTest {
	public void testFlipAndInvertImage() {
		int[][] A = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
		FlippingAnImage flippingAnImage = new FlippingAnImage();
		int[][] result = flippingAnImage.flipAndInvertImage(A);
		int[][] expected = {{1, 0, 0}, {0, 1, 0}, {1, 1, 1}};
		
		for (int[] res : result) {
			System.out.println(Arrays.toString(res));
		}
	}

	public static void main(String[] args) {
		FlippingAnImageTest ft = new FlippingAnImageTest();
		ft.testFlipAndInvertImage();
	}
}
