import java.util.*;

public class RobotInAGridUsingQueue
{
    static class Point
    {
        int R;
        int C;

        Point(int r, int c) { R = r; C = c;}

        public String toString() { return " (" + R + "," + C + "),"; }
        
        public boolean equals(Object o)
        {
            Point p = (Point) o;
            if (p.R == R && p.C == C)
                return true;
            return false;
        }
        
        Point parent;
        boolean visited;
    }

    public static void gridPath(int row, int col, boolean[][] board)
    {
        Point p = new Point(0, 0);   // starting position. If a path is found will be the ending position;
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        boolean reachable = false;
        int count = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            cur.visited = true;

            if (cur.R == row && cur.C == col) {
                p = cur;
                reachable = true;
                break;
            }
            
            if(reachable(cur.R + 1, cur.C, board)) {
                Point p1 = new Point(cur.R + 1, cur.C);
                p1.parent = cur;
                queue.add(p1);
            }

            if (reachable (cur.R, cur.C + 1, board)) {
                Point p1 = new Point(cur.R, cur.C + 1);
                p1.parent = cur;
                queue.add(p1);
            }
        }

        if (reachable) {
            printparents(p);
        } else {
            System.out.println("Could not reach");
        }

    }

    private static boolean reachable(int row, int col, boolean[][] board)
    {
        if (row < board.length && col < board[0].length && board[row][col])
            return true;
        else
            return false;
    }

    private static void printparents(Point p)
    {
        if (p== null)
            return;
        System.out.print(p);
        printparents(p.parent);
    }

    public static void main(String[] args)
    {
	boolean[][] maze = new boolean[4][5];

	for (int i = 0; i < maze.length; i++)
	    Arrays.fill(maze[i], true);

        
	// create a path
	maze[0][0] = true;
	maze[0][1] = true;
	maze[0][2] = true;
	maze[1][2] = true;
	maze[1][3] = true;
	maze[1][4] = true;
	maze[2][4] = true;
	maze[3][4] = true;
        

	// Everything is true. Lets block some areas on bottom left
        /*
	maze[2][0] = false;
	maze[3][0] = false;
	maze[2][1] = false;
        */
	
	gridPath(3,4,maze);
    }
}
