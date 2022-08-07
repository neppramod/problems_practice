import java.util.*;

public class LengthOfString {
    public static void main(String[] args) {
	    LengthOfString sol = new LengthOfString();
        String s = "GeeksforGeeks";
        System.out.println(sol.lengthOfString(s));
	}

    // we have to assume we don't have access to length method of string
    // therefore, we can only check when the string becomes empty
    public int lengthOfString(String s) {
        if (s.equals("")) {
            return 0;
        } else {
            return 1 + lengthOfString(s.substring(1));
        }
    }
}
