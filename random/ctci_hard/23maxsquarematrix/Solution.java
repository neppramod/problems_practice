/*

Max Square Matrix

1 0 0 0 0 0
0 1 1 1 1 0
0 1 0 0 1 1
0 1 0 0 1 0
0 1 1 1 1 1

squareSize => 6,5,4,3,2,1

findSquareWithSize(matrix, 6):
   count = 6-6+1

   for (row = 0; row < 1; row++) {
     for col = 0; col < 1; col++:
       isSquare(matrix, 0, 0, 6)
   }

   isSquare(matrix, 0, 0, 6):
     for j = 0; j < 6; j++:
        if (matrix[0][0+j] == 1) // white
           return false
        if (matrix[row+size-1][col+j] == 1) return false;

     for i = 1; i < 5; i++   // already checked top, bottom row:
         if (matrix[row+i][col] == 1) return false;
         if (matrix[row+i][col+size-1] == 1) return false;


Pre-Processing Solution: O(N^3)

A large part of the slowness of the "simple" solution above is due to the fact we have to do O(N) work each time we want to check a potential square.

By doing some pre-processing, we can cut down the time of isSquare to O(1). The time of the whole algorithm is reduced to O(N^3).

If we analyze what isSquare does, we realize that all it ever needs to know is if the next squareSize items on the right of as well as below particular cells, are zeros.


We iterate from right to left and bottom to top. At each cell, we do the following computation:


if A[r][c] is white, zeros right and zeros below are 0

 W B W
 B B W
 B B W

           0,0  1,3   0,0
           2,2  1,2   0,0
           2,1  1,1   0,0

if A[r][c] == w, A[r][c].zerosRight = 0 and A[r][c].zerosBelow = 0
else A[r][c].zerosRight = A[r][c+1].zerosRight+1
     A[r][c].zerosBelow = A[r+1][c].zerosBelow + 1

Now, instead of iterating through O(N) elements, the isSquare method just needs to check zerosRight and zerosBelow for the corners

 */


public class Solution
{

    public static void main(String[] args)
    {
        int[][]  matrix = {
            {1, 0, 1},
            {0, 0, 1},
            {0, 0, 1},
        };

        Subsquare square = findSquare(matrix);
        System.out.println(square);
    }
    
    private static class Subsquare
    {
        int row, col, squareSize;
        public Subsquare(int row, int col, int squareSize) {
            this.row = row; this.col = col; this.squareSize = squareSize;
        }

        public String toString() {
            return "Row: " + row + ", Col: " + col + ", Size: " + squareSize;
        }
    }

    private static class SquareCell
    {
        public int zerosRight = 0;
        public int zerosBelow = 0;

        public SquareCell(int zerosRight, int zerosBelow) { this.zerosRight = zerosRight; this.zerosBelow = zerosBelow; }
    }

    private static Subsquare findSquare(int[][] matrix)
    {
        SquareCell[][] processed = processSquare(matrix);
        for (int i = matrix.length; i>= 1; i--) {
            Subsquare square = findSquareWithSize(processed, i);
            if (square != null) return square;
        }

        return null;
    }

    private static Subsquare findSquareWithSize(SquareCell[][] matrix, int squareSize)
    {
        int count = matrix.length - squareSize + 1;

        for (int row = 0; row < count; row++) {
            for (int col = 0; col < count; col++) {
                if (isSquare(matrix, row, col, squareSize)) {
                    return new Subsquare(row, col, squareSize);
                }
            }
        }

        return null;
    }

    private static boolean isSquare(SquareCell[][] matrix, int row, int col, int size)
    {
        SquareCell topLeft = matrix[row][col];
        SquareCell topRight = matrix[row][col + size - 1];
        SquareCell bottomLeft = matrix[row + size - 1][col];

        // check top, left, right and bottom edges, respectively
        if (topLeft.zerosRight < size || topLeft.zerosBelow < size || topRight.zerosBelow < size || bottomLeft.zerosRight < size) {
            return false;
        }

        return true;
    }

    private static SquareCell[][] processSquare(int[][] matrix)
    {
        SquareCell[][] processed = new SquareCell[matrix.length][matrix.length];

        for (int r = matrix.length - 1; r >= 0; r--) {
            for (int c = matrix.length - 1; c >= 0; c--) {

                int rightZeros = 0;
                int belowZeros = 0;

                // only process if black cell
                if (matrix[r][c] == 0) {
                    rightZeros++;
                    belowZeros++;

                    // next column over is on same row
                    if (c+1 < matrix.length) {
                        SquareCell previous = processed[r][c+1];
                        rightZeros += previous.zerosRight;
                    }

                    if (r+1 < matrix.length) {
                        SquareCell previous = processed[r+1][c];
                        belowZeros += previous.zerosBelow;
                    }
                }

                processed[r][c] = new SquareCell(rightZeros, belowZeros);
            }
        }

        return processed;
    }
}
