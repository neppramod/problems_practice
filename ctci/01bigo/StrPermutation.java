
public class StrPermutation
{
    public static void permutation(String str, String prefix)
    {
	if (str.length() == 0) {
	    System.out.print(prefix + " ");
	} else {

	    for (int i = 0; i < str.length(); i++) {
		String rem = str.substring(0, i) + str.substring(i + 1);
		permutation(rem, prefix+str.charAt(i));
	    }
	}
    }

    public static void main(String[] args)
    {
	String abc = "abcd";
	permutation(abc, "");
	/*
	for (int i = 1; i <= abc.length(); i++) {
	    permutation(abc.substring(0, i),"");
	}
	*/
    }
}

