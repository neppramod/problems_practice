import java.util.*;

public class Palindrome
{

    public static int palindromeStepsCounter(String str)
    {
        int count = 0;
        
        for (int i = 0; i < str.length()/2; i++) {
            int front = str.charAt(i);
            int back = str.charAt(str.length() - 1 - i);

            if (front > back) {
                while (front != back) {
                    front = front - 1;
                    count++;
                }
            } else if (back > front) {
                while (back != front) {
                    back = back - 1;
                    count++;
                }
            }
        }

        return count;
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); sc.nextLine();
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < T; i++) {
            list.add(sc.nextLine().trim());
        }

        for (String str : list) {
            System.out.println(palindromeStepsCounter(str));
        }
        
    }
}
