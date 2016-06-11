import java.util.*;

public class Robot
{
    private static class Point
    {
        int X, Y;
        Point(int x, int y) { X = x; Y = y;}

        public String toString() { return "(" + X +"," + Y + ") "; }

        public boolean equals(Object o)
        {
            Point p1 = (Point)o;
            return p1.X == this.X && p1.Y == this.Y;
        }
    }
    public static boolean path(int row, int col, int[][] board, ArrayList<Point> list, HashSet<Point> duplicates)
    {
        if (board == null || board.length == 0)
            return false;

        if (row < 0 || col < 0 || board[row][col] == -1)
            return false;

        if (duplicates.contains(new Point(row, col)))
            return false;

        boolean atOrigin = row == 0 && col == 0;

        if (atOrigin || path(row,col-1,board,list, duplicates) || path(row-1, col, board, list, duplicates)) {
            list.add(new Point(row, col));
            return true;
        }

        duplicates.add(new Point(row, col));
        return false;        
    }

    public static void main(String[] args)
    {
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> duplicates = new HashSet<>();
        int[][] board = new int[5][6];

        board[1][0] = -1;
        board[0][3] = -1;
        board[2][2] = -1;
        board[4][2] = -1;

        if (path(4, 5, board, path, duplicates))
            System.out.println(path);
        else
            System.out.println("No path");
    }
}
