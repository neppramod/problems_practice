public class Permutation02
{
    static boolean isPermutation(String s1, String s2)
    {
        char x = 0;
        for (int i = 0; i < s1.length(); i++) {
            x ^= s1.charAt(i);
            x ^= s2.charAt(i);
        }

        return x==0 ? true : false;
    }

    public static void main(String[] args)
    {
        System.out.println(isPermutation("abcefgad", "dabgafce"));
        System.out.println(isPermutation("abd", "bac"));
    }
}
