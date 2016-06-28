import java.util.*;

public class Permutations
{
	static int counter = 0;

    void generatePermutations(String str, String prefix, ArrayList<String> permutations)
    {
    	counter++;
        if (str.length() == 0) {
        	if (!permutations.contains(prefix))
	            permutations.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String trimmedString = str.substring(0, i) + str.substring(i+1);
                generatePermutations(trimmedString, prefix+str.charAt(i), permutations);
            }
        }
    }

    public static void main(String[] args)
    {
        Permutations pms = new Permutations();
        ArrayList<String> list = new ArrayList<>();
        pms.generatePermutations("abaac", "", list);
        System.out.println(list);
        System.out.println(counter);
    }
}
