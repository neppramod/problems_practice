public class StringRotation19
{
    public static boolean isSubstring(String str1, String str2)
    {
        str2 = str2+str2;

        int j = 0;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == str1.charAt(j)) {
                j++;
            } else {
                j = 0;
            }

            if (j == str1.length())
                return true;
        }

        return false;        
    }

    public static void main(String[] args)
    {
        System.out.println(isSubstring("waterbottle", "erbottlewat"));
        System.out.println(isSubstring("abcde", "cdea"));
    }
}
