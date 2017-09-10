public class Maze
{

    private void fillMaze(char[][] maze)
    {
        maze[0][0] = '*';
        maze[1][0] = '*';
        maze[2][0] = '*';
        maze[3][0] = '*';
        maze[4][0] = '*';
        maze[5][0] = '*';
        maze[6][0] = '*';
        maze[0][1] = '*';
        maze[2][1] = 'S';
        maze[6][1] = '*';
        maze[0][2] = '*';
        maze[2][2] = '*';
        maze[4][2] = '*';
        maze[6][2] = '*';
        maze[0][3] = '*';
        maze[2][3] = '*';
        maze[6][3] = '*';
        maze[0][4] = '*';
        maze[1][4] = '*';
        maze[2][4] = '*';
        maze[3][4] = '*';
        maze[5][4] = '*';
        maze[6][4] = '*';
        maze[7][4] = '*';
        maze[3][5] = '*';
        maze[7][5] = '*';
        maze[3][6] = '*';
        maze[6][6] = 'E';
        maze[7][6] = '*';
        maze[3][7] = '*';
        maze[4][7] = '*';
        maze[5][7] = '*';
        maze[6][7] = '*';
        maze[7][7] = '*';
    }

    public static void main(String[] args)
    {
        char[][] maze = new char[8][8];
        Maze m = new Maze();
        m.fillMaze(maze);
        System.out.println(m.isMazeSolvable(maze));
    }

    public boolean isMazeSolvable(char[][] maze)
    {
        int startX = -1, startY = -1;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        if (startX == -1) return false;
        return exploreMaze(maze, startX, startY);
    }

    private boolean exploreMaze(char[][] maze, int x, int y)
    {
        if (x < 0 || x > maze.length || y < 0 || y > maze[0].length) return false;

        if (maze[x][y] == 'E') return true;
        if (maze[x][y] == '*') return false;

        // visited
        maze[x][y] = '*';

        System.out.printf("(%d, %d) ", x, y);

        // try all options from current position
        if (exploreMaze(maze, x - 1, y)) return true;
        if (exploreMaze(maze, x + 1, y)) return true;
        if (exploreMaze(maze, x, y - 1)) return true;
        if (exploreMaze(maze, x, y + 1)) return true;

        // if none of the above options worked, maze cannot be explored from current position
        return false;
    }
}
