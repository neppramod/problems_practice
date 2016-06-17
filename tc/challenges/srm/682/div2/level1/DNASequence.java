
import java.util.*;

public class DNASequence
{
    public int longestDNASequence(String sequence)
    {
	int count = 0;
        int max = 0;

        for (int i = 0; i < sequence.length(); i++) {
            char ch = sequence.charAt(i);

            if (ch == 'C' || ch == 'G' || ch == 'T' || ch == 'A') {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        DNASequence ds = new DNASequence();
        System.out.println(ds.longestDNASequence("VVZWKCSIQEGANULDLZESHUYHUQGRKUMFCGTATGOHMLKBIRCA"));
    }
}
