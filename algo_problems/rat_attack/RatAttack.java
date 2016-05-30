import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * Rat attack problem. As specified in
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=362&page=show_problem&problem=1301
 * Print the minimum index block that has the maximum effect
 * Following input is used in d.ratattack.txt file. Change to System.in to read from console.
 * <p>
 * 1
 * 1
 * 2
 * 4 4 10
 * 6 6 20
 */

public class RatAttack {

    private final int BLOCK_SIZE = 1025;        // Size of the block
    private int[][] block;                      // The city blocks. We will use this to store strengths of rat population
    private ArrayList<Population> populations;  // Rat population list
    private Scanner sc;                         // Scanner to read input
    private int strength;                       // Bomb strength

    public RatAttack() {
        try {
            sc = new Scanner(new File("d.ratattack.txt"));
            //sc = new Scanner(System.in);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        RatAttack ratAttack = new RatAttack();
        ratAttack.test();
    }

    // Reads user input
    private void readInput() {

        // Strength of the bomb
        int d = sc.nextInt();
        this.strength = d;

        if (d < 1 && d > 50)
            throw new RuntimeException("Strength of the bomb is out of range");

        // Number of rat populations (clusters)
        int n = sc.nextInt();

        if (n < 1 && n > 20000)
            throw new RuntimeException("Number of rat populations is out of range");

        // For each cluster
        for (int j = 0; j < n; j++) {

            // X coordinate of the rat population
            int x = sc.nextInt();

            // Y coordinate of the rat population
            int y = sc.nextInt();

            // Rat population at (X,Y)
            int size = sc.nextInt();

            // Add rat population to the populations list
            populations.add(new Population(x, y, size));
        }
    }

    // Updates the strength of blocks covered from a coordinate using the bomb strength
    private void updateBlock() {
        for (Population population : populations) {
            int x = population.getX();
            int y = population.getY();
            int populationSize = population.getSize();

            // Cover all the rectangles with radius strength around x and y
            for (int i = x - strength; i <= x + strength; i++) {
                for (int j = y - strength; j <= y + strength; j++) {
                    // Add population to the coverage area that falls witin the block boundary
                    if (i >= 1 && i < BLOCK_SIZE && j >= 1 && j < BLOCK_SIZE) {
                        block[i][j] += populationSize;
                    }
                }
            }
        }
    }

    // Get maximum population
    // As specified by the question, find the first block that has maximum coverage
    public Population getMaxiumPopulation() {
        int maximumPopulationSize = 0;
        int x = 1;
        int y = 1;

        // Scan from left,top
        for (int i = 1; i < BLOCK_SIZE; i++) {
            for (int j = 1; j < BLOCK_SIZE; j++) {
                if (maximumPopulationSize < block[i][j]) {
                    x = i;
                    y = j;

                    maximumPopulationSize = block[i][j];
                }
            }
        }

        return new Population(x, y, maximumPopulationSize);
    }

    // Test rat attack
    public void test() {
        // No. of scenarios
        int scenarios = sc.nextInt();

        // For each scenario
        for (int i = 0; i < scenarios; i++) {

            // First initialize the object variables
            // We want to set these variables new for each scenario

            block = new int[BLOCK_SIZE][BLOCK_SIZE];
            populations = new ArrayList<>();

            readInput();
            updateBlock();
            Population population = getMaxiumPopulation();

            System.out.println(population.getX() + " " + population.getY() + " " + population.getSize());
        }
    }

    // Encapsulates coordinates and rat population at the coordinate
    public class Population {
        private int x;
        private int y;
        private int size;

        public Population(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
