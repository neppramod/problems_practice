import java.util.*;

public class CCipher
{
    String decode(String cipherText, int shift)
    {
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String mixedAlphabets = alphabets + alphabets;

        char[] mixedalphabetchars = mixedAlphabets.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            sb.append(mixedalphabetchars[26+cipherText.charAt(i) - 'A' - shift]);
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        CCipher cc = new CCipher();
        System.out.println(cc.decode(sc.nextLine(), sc.nextInt()));
    }
}
