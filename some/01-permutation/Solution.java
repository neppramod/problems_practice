import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] ch = {'a', 'b', 'c'};
        permute(ch, ch.length, 0);
    }

    static void permute(char[] ch, int n, int index)
    {
        if (index == n) {
            System.out.println(Arrays.toString(ch));
        } else {
            for (int j = index; j < n; j++) {
                swap(ch, index, j);
                permute(ch, n, index+1);
                swap(ch, index, j);
            }
        }
    }

    static void swap(char[] ch, int i, int j)
    {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }
}
