package datascience.tutorial.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * grafixMask
 * SRM 211 Division I Level Two
 * Recursion
 */
public class FloodFill {
    private static int ROWS = 400;
    private static int COLS = 600;

    public static void main(String[] args) {
        FloodFill ff = new FloodFill();
        ff.printSortedAreas(new String[]{"0 292 399 307"});
        ff.printSortedAreas(new String[]{"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"});
        ff.printSortedAreas(new String[]{"0 192 399 207", "0 392 399 407", "120 0 135 599", "260 0 275 599"});
        ff.printSortedAreas(new String[]{"50 300 199 300", "201 300 350 300", "200 50 200 299", "200 301 200 550"});
        ff.printSortedAreas(new String[]{"0 20 399 20", "0 44 399 44", "0 68 399 68", "0 92 399 92",
                "0 116 399 116", "0 140 399 140", "0 164 399 164", "0 188 399 188",
                "0 212 399 212", "0 236 399 236", "0 260 399 260", "0 284 399 284",
                "0 308 399 308", "0 332 399 332", "0 356 399 356", "0 380 399 380",
                "0 404 399 404", "0 428 399 428", "0 452 399 452", "0 476 399 476",
                "0 500 399 500", "0 524 399 524", "0 548 399 548", "0 572 399 572",
                "0 596 399 596", "5 0 5 599", "21 0 21 599", "37 0 37 599",
                "53 0 53 599", "69 0 69 599", "85 0 85 599", "101 0 101 599",
                "117 0 117 599", "133 0 133 599", "149 0 149 599", "165 0 165 599",
                "181 0 181 599", "197 0 197 599", "213 0 213 599", "229 0 229 599",
                "245 0 245 599", "261 0 261 599", "277 0 277 599", "293 0 293 599",
                "309 0 309 599", "325 0 325 599", "341 0 341 599", "357 0 357 599",
                "373 0 373 599", "389 0 389 599"});

    }

    private static void printGrid(boolean[][] grid) {
        for (int i = 0; i < grid.length; i++)
            System.out.println(Arrays.toString(grid[i]));
    }

    private void printSortedAreas(String[] strings) {
        Integer[] sortedAreas = sortedAreas(strings);
        for (int i = 0; i < sortedAreas.length; i++) {
            System.out.print(sortedAreas[i] + " ");
        }
        System.out.println();
    }

    public Integer[] sortedAreas(String[] rectangles) {
        boolean[][] grid = new boolean[ROWS][COLS];
        for (int i = 0; i < rectangles.length; i++) {
            int[] coordinates = getcoordinates(rectangles[i]);

            preFillRect(grid, coordinates);
        }


        int count = 0;

        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (!grid[i][j]) {
                    results.add(doFill(grid, i, j, ROWS, COLS));
                }
            }
        }

        Collections.sort(results);

        return results.toArray(new Integer[results.size()]);
    }

    private int doFill(boolean[][] grid, int x, int y, int maxx, int maxy) {
        Stack stack = new Stack();
        stack.push(new Node(x, y));
        int result = 0;

        while (!stack.empty()) {
            Node top = (Node) stack.pop();

            if (top.x < 0 || top.x >= maxx) continue;
            if (top.y < 0 || top.y >= maxy) continue;
            if (grid[top.x][top.y]) continue;

            result++;
            grid[top.x][top.y] = true;

            stack.push(new Node(top.x - 1, top.y));
            stack.push(new Node(top.x + 1, top.y));
            stack.push(new Node(top.x, top.y - 1));
            stack.push(new Node(top.x, top.y + 1));

        }

        return result;
    }

    private void preFillRect(boolean[][] grid, int[] coordinates) {
        for (int i = coordinates[0]; i <= coordinates[2]; i++) {
            for (int j = coordinates[1]; j <= coordinates[3]; j++) {
                grid[i][j] = true;
            }
        }
    }

    private int[] getcoordinates(String rectangle) {
        int[] coordinates = new int[4];
        String[] coordstr = rectangle.split(" ");
        for (int i = 0; i < 4; i++) {
            coordinates[i] = Integer.parseInt(coordstr[i]);
        }
        return coordinates;
    }

    static class Node {
        int x, y;

        public Node(int x1, int y1) {
            x = x1;
            y = y1;
        }

        @Override
        public boolean equals(Object obj) {
            Node n = (Node) obj;
            return n.x == x && n.y == y;
        }
    }
}
