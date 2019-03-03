import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] sum = new int[10];
        Arrays.fill(sum, 0);

        int input = sc.nextInt();


        for (int i = 1; i <= input; i++) {
            List<Integer> digits = getDigits(i);


            for (int j = 0; j < digits.size(); j++) {
                sum[digits.get(j)]++;
            }
        }



        int total = 0;

        for (int i = 1; i < 10; i++) {
            total += i * sum[i];
        }

        System.out.println(total);
    }

    static List<Integer> getDigits(int input)
    {
        List<Integer> list = new ArrayList<>();

        while (input > 0) {

            list.add(input%10);
            input/=10;
        }


        return list;
    }
}


/*
n = 5,
1 2 3 4 5

n = 12
1 2 3 4 5 6 7 8 9 10 11 12
 */
