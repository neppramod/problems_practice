import java.util.*;

public class RobotInAGrid
{
    static class Point
    {
	int x;
	int y;
	public Point(int x, int y) { this.x = x; this.y = y; }
	public boolean equals(Object o)
	{
	    Point p = (Point) o;
	    if (this.x == p.x && this.y == p.y)
		return true;

	    return false;
	}

	public String toString()
	{
	    return "[" + this.x + ", " + this.y + "]";
	}
    }
    static ArrayList<Point> getPath(boolean[][] mesh)
    {
	if (mesh == null || mesh.length == 0)
	    return null;
	
	ArrayList<Point> path = new ArrayList<>();
	HashSet<Point> badPath = new HashSet<>();
	
	if (getPath(mesh, mesh.length - 1, mesh[0].length - 1, path, badPath)) {
	    return path;
	}

	return null;
    }

    static boolean getPath(boolean[][] mesh, int row, int col, ArrayList<Point> path, HashSet<Point> badPath)
    {
	if (row < 0 || col < 0 || !mesh[row][col])
	    return false;

	Point curPoint = new Point(row, col);

	if (badPath.contains(curPoint))
	    return false;
	
	boolean isOrigin = row == 0 && col == 0;
	
	if (isOrigin || getPath(mesh, row, col - 1, path, badPath)
	    || getPath(mesh, row - 1, col, path, badPath)) {
	    path.add(curPoint);
	    return true;
	}

	badPath.add(curPoint);
	
	return false;
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
	maze[2][0] = false;
	maze[3][0] = false;
	maze[2][1] = false;
	
	System.out.println(getPath(maze));
    }
}
