public class Matrix
{
	public static void transpose(int[][] array)
	{
		int N = array.length;

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int tmp = array[i][j];
				array[i][j] = array[j][i];
				array[j][i] = tmp;
			}
		}
	}

	// copy first column to last and so on until middle
	public static void mirror(int[][] array)
	{
		int N = array.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N/2; j++) {
				int tmp = array[i][j];
				array[i][j] = array[i][N-1-j];
				array[i][N-1-j] = tmp;
			}
		}
	}

	public static void print(int[][] array)
	{
		int N = array.length;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(array[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		int[][] array = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
				};

		print(array);
		transpose(array);
		print(array);
		mirror(array);

		System.out.println("After rotation from first");
		print(array);
	}
}
