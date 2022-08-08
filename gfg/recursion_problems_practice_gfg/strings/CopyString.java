import java.util.*;

public class CopyString {
    public static void main(String[] args) {
	    CopyString sol = new CopyString();
        char[] s1 = "GEEKSFORGEEKS".toCharArray();
        char[] s2 = new char[s1.length];
        sol.copy(s1, s2, 0);
        System.out.println(s2);
	}

    private void copy(char[] s1, char[] s2, int i) {
        if (i >= s1.length) {
            return;
        } else {
            s2[i] = s1[i];
            copy(s1, s2, i + 1);
        }
    } 
}
