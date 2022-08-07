import java.util.*;

public class FirstUpperCaseCharacterInString {
    public static void main(String[] args) {
	    FirstUpperCaseCharacterInString sol = new FirstUpperCaseCharacterInString();
		String s = "geeks";
        System.out.println(sol.firstUpperCaseCharacter(s));
	}
	
    public Character firstUpperCaseCharacter(String s) {
        return firstUpperCaseCharacter(s, 0);
    }

    private Character firstUpperCaseCharacter(String s, int i) {
        if (i >= s.length()) {
            return null;
        } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
            return s.charAt(i);
        } else {
            return firstUpperCaseCharacter(s, i + 1);
        }
    }
}
