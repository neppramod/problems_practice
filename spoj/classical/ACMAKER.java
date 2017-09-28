import java.util.*;

public class ACMAKER
{
    static int maxCount(String[] words, char[] acro)
    {
        int[][] sum = new int[75][75];
        int[][] sum2 = new int[75][75];

        // base case
        sum[0][0] = 1;

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < acro.length; j++) {
                char[] wrds = words[i].toCharArray();
                int mx = Math.min(wrds.length, acro.length - j);

                // fill all of first column with 1
                // we will use this column to derive value for others in case of match
                for (int k = 0; k <= wrds.length; k++) {
                    sum2[k][0] = 1;
                }

                for (int k = 0; k < wrds.length; k++) {
                    for (int m = 0; m < mx; m++) {
                        // copy values from previous row
                        sum2[k+1][m+1] = sum2[k][m+1];

                        // if there is a match, add value from diagonal
                        if (wrds[k] == acro[j+m]) {
                            sum2[k+1][m+1] += sum2[k][m];
                        }
                    }
                }

                for (int k = 1; k <= mx; k++) {
                    sum[i+1][j+k] += sum[i][j] * sum2[wrds.length][k];
                }
            }
        }

        return sum[words.length][acro.length];
    }

    static String[] filterWords(String line, String[] insigwords)
    {
        String[] words = line.split(" ");
        int k = words.length;

        for (int i =  0; i < insigwords.length; i++) {
            for (int j = 0; j < words.length; j++) {
                String ins = insigwords[i].trim();
                String wrd = words[j];
                if (wrd != null) wrd = wrd.trim();

                if (wrd != null && ins.length() > 0 && ins.equals(wrd)) {
                    words[j] = null;
                    k--;
                }
            }
        }

        String[] filteredWords = new String[k];
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                filteredWords[j] = words[i];
                j++;
            }
        }

        return filteredWords;
    }

    public static void main(String[] args)
    {
        //String[] words = {"academy", "computer", "makers"};
        //char[] acro = "acm".toCharArray();
        Scanner sc = new Scanner(System.in);
        while(true) {
            int N = sc.nextInt();
            if (N == 0)break;
            String[] insigwords = new String[N];
            for (int i = 0; i < insigwords.length; i++) {
                insigwords[i] = sc.next();
            }

            // line feed
            sc.nextLine();
            while(true) {
                String line = sc.nextLine();
                if ("LAST CASE".equals(line.trim())) break;

                String[] filteredWords = filterWords(line, insigwords);
                String acronym = filteredWords[0];
                char[] acro = acronym.toLowerCase().toCharArray();
                String[] words = new String[filteredWords.length-1];
                System.arraycopy(filteredWords, 1, words, 0, words.length);

                String output = "";
                int count = maxCount(words, acro);
                if (count > 0)
                    output = String.format("%s can be formed in %d ways", acronym, count);
                else
                    output = String.format("%s is not a valid abbreviation", acronym);

                System.out.println(output);
            }
        }
    }
}
