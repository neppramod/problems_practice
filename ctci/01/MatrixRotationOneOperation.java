class MatrixRotationOneOperation
{
    static void rotate(int[][] array)
    {
	int N = array.length;
	for (int level = 0;  level < N / 2; level++) {
	    int first = level;
	    int last = N - 1 - level;

	    for (int j = level; j < last; j++) {
		int offset = j - first;

		int tmp = array[first][j];
		array[first][j] = array[last - offset][first];
		array[last - offset][first] = array[last][last - offset];
		array[last][last - offset] = array[j][last];
		array[j][last] = tmp;
	    }
	}
    }

    static void print(int[][] array)
    {
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[0].length; j++) {
		System.out.print(array[i][j] + " ");
	    }

	    System.out.println();
	}
    }

    public static void main(String[] args) {
	int[][] array = {
	    {1,2,3,4,5},
	    {6,7,8,9,10},
	    {11,12,13,14,15},
	    {16,17,18,19,20},
	    {21,22,23,24,24},
	};

	rotate(array);
	print(array);
    }
}
