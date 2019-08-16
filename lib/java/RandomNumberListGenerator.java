import java.util.*;

public class RandomNumberListGenerator
{
    private static final Random random = new Random();
    public static int[] getRandomList(int n, int inclusiveLowerBound, int inclusiveUpperBound)
    {
        if (n <= 0 || inclusiveLowerBound < 0 || inclusiveLowerBound > inclusiveUpperBound) return new int[] {-1};

        int[] generatedList = new int[n];
        int bound = inclusiveUpperBound - inclusiveLowerBound + 1;

        for (int i = 0; i < n; i++) {
            generatedList[i] = random.nextInt(bound) + inclusiveLowerBound;
        }

        return generatedList;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lowerBound = sc.nextInt();
        int upperBound = sc.nextInt();
        System.out.println(Arrays.toString(getRandomList(n, lowerBound, upperBound)));
    }
}
