import java.util.*;

public class PaintFill
{
    public void fillColor(int[][] screen, int row, int col, int newColor)
    {
        int oldColor = screen[row][col];
        fillColor(screen, row, col, newColor, oldColor);
    }

    public void print(int[][] screen)
    {
        for (int i = 0; i < screen.length; i++) {
            System.out.println(Arrays.toString(screen[i]));
        }
        System.out.println();
    }

    public void fillColor(int[][] screen, int row, int col, int newColor, int oldColor)
    {
        if (screen == null) return;

        if (row < 0 || row >= screen.length || col < 0 || col >= screen[0].length)
            return;

        if (screen[row][col] == oldColor) {
            screen[row][col] = newColor;

            fillColor(screen, row + 1, col, newColor, oldColor);
            fillColor(screen, row - 1, col, newColor, oldColor);
            fillColor(screen, row, col - 1, newColor, oldColor);
            fillColor(screen, row, col + 1, newColor, oldColor);
        }
    }

    public static void main(String[] args)
    {
        // 1 = Black, 2 = Green, 3 = Red. Fill Green with Red
        int[][] screen = {
            {1, 1, 1, 1},
            {1, 2, 2, 1},
            {1, 1, 2, 1},
            {1, 1, 1, 1},
        };

        PaintFill pf = new PaintFill();
        pf.print(screen);
        pf.fillColor(screen, 1, 2, 3);
        pf.print(screen);
    }
}
