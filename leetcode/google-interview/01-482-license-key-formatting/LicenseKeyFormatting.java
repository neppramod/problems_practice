import java.util.*;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
	    LicenseKeyFormatting sol = new LicenseKeyFormatting();
		
		String S = "2-5g-3-J";
		int K = 2;

		System.out.println(sol.licenseKeyFormatting(S, K));
		
	}

	// Start adding letters from end, omit any -
	// if current buffer size becomes k, add it to result, prepend with
	// if it is not first time.
    public String licenseKeyFormatting(String S, int K) {

		if (S == null || S.length() == 0) {
			return S;
		}
		
        StringBuilder sb = new StringBuilder();
		int n = S.length();
		StringBuilder tmpBuilder = new StringBuilder();
		boolean firstTime = true;
		
		for (int i = n-1; i >= 0; i--) {
			char c = S.charAt(i);

			if (c != '-') {
				tmpBuilder.append(Character.toUpperCase(c));
			}

			if (tmpBuilder.length() == K) {
				if (firstTime) {
					sb.append(tmpBuilder);
					firstTime = false;
				} else {
					sb.append("-").append(tmpBuilder);
				}
				tmpBuilder = new StringBuilder();
			}
		}

		if (tmpBuilder.length() > 0) {
			if (firstTime) {
				sb.append(tmpBuilder);
			} else {
				sb.append("-").append(tmpBuilder);
			}
		}

		return sb.reverse().toString();
    }
}
