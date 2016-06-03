public class OneAway15
{
    static boolean oneaway(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();

        int j = 0;
        int mismatched = 0;
        
        for (int i = 0; i < len1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);

            if (ch1 == ch2) {
                j++;
            } else {
                mismatched++;
                if (i + 1 < len1 && ch2 == str1.charAt(i+1)) {
                    continue;
                }

                j++;

                if (mismatched > 1) {
                    return false;
                }
            }

            if (j == len2)
                return true;
        }

        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(oneaway("pale", "ple"));
        System.out.println(oneaway("pales", "pale"));
        System.out.println(oneaway("pale", "bale"));
        System.out.println(oneaway("pale", "bake"));
    }
}
