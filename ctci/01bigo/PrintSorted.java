public class PrintSorted
{
    static final int numOfChars = 26;

    public static void printSorted(int k)
    {
	printSorted(k, "");
    }

    private static void printSorted(int remaining, String prefix)
    {
	if (remaining < 0) {
	    return;	
	}
	if (remaining == 0) {
	    if (sorted(prefix)) {
		System.out.println(prefix);
	    }
	} else {
	    for (int i = 0; i < numOfChars; i++) {
		char c = getChar(i); // Character index of english alphabet
		printSorted(remaining - 1, prefix + c);
	    }
	}
    }

    private static boolean sorted(String str)
    {
	for (int i = 1; i < str.length(); i++) {
	    if (getChar(i) < getChar(i-1)) {
		return false;
	    }
	}

	return true;
    }

    private static char getChar(int i)
    {
	return (char)('a' + i);
    }

    public static void main(String[] args)
    {
	printSorted(3);
    }
}
