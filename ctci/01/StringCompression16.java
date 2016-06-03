public class StringCompression16
{
    public static String compress(String str)
    {
        boolean hasDuplicate = false;
        int countChars = 0;
        char prevChar = str.charAt(0);
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == prevChar) {
                countChars++;
            } else {
                sb.append(prevChar);
                sb.append(countChars);
                
                if (countChars > 1) {
                    hasDuplicate = true;
                }

                // reset count
                countChars = 1;                                    
                prevChar = str.charAt(i);
            }

            if (i == str.length() && countChars > 1) {
                sb.append(prevChar);
                sb.append(countChars);
            }
        }

        if (hasDuplicate) {
            return sb.toString();
        } else {
            return str;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(compress("aabcccccaaa"));
    }
}
