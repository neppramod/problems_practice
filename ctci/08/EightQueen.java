import java.util.*;

// All the ways to place queens. Not just one
public class EightQueen
{
    static int BOARD_SIZE = 8;
    //static int count;

    public static void placeQueen(Integer[] columns, int row, ArrayList<Integer> results)
    {
	if (row == BOARD_SIZE) {
	    results.addAll(new ArrayList<Integer>(Arrays.asList(columns.clone())));
            //count++;
            return;
	} else {

            for (int col = 0; col < BOARD_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col;
                    placeQueen(columns, row + 1, results);
                }
            }
        }
    }

    private static boolean checkValid(Integer[] columns, int row, int col)
    {
	for(int row2 = 0; row2 < row; row2++) {
            int col2 = columns[row2];
	    if (col == col2)
		return false;

	    if (Math.abs(row - row2) == Math.abs(col2 - col))
		return false;
	}

	return true;
    }

    public static void main(String[] args)
    {
	ArrayList<Integer> results = new ArrayList<>();
	placeQueen(new Integer[BOARD_SIZE], 0, results);
        //System.out.println(results.size());
        //System.out.println("Count: " + count);
	System.out.println(results);
    }
}
