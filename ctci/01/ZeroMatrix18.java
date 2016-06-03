import java.util.*;

public class ZeroMatrix18
{
    static class Point
    {
        int x, y;
        
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void zeromatrix(int[][] array)
    {
        ArrayList<Point> zeroPoints = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 0) {
                    zeroPoints.add(new Point(i, j));
                }
            }
        }

        for (Point point : zeroPoints) {
            clearRowsCols(array, point);
        }        
    }

    static void clearRowsCols(int[][] array, Point point)
    {
        for (int i = 0; i < array.length; i++) {
            array[i][point.y] = 0;
        }

        for (int j = 0; j < array[0].length; j++) {
            array[point.x][j] = 0;
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
    
    public static void main(String[] args)
    {
        int[][] array = {{5,7,3,7,3},
                         {6,3,0,4,2},
                         {7,4,2,7,5},
                         {1,0,3,6,8},
                         {7,2,3,5,7}};

        
        zeromatrix(array);
        print(array);
    }
}
 
