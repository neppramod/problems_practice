import java.util.*;

public class CreatingStrings {
    public static void main(String[] args) {
	    CreatingStrings sol = new CreatingStrings();
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		List<String> r = sol.combinations(input);
		if (r.size() == 0) {
			System.out.println("0");
		} else {
			System.out.println(r.size());
			Collections.sort(r);
			for (String s : r) {
				System.out.println(s);
			}
		}
	}

	public List<String> combinations(String s) {
		Set<String> result = new HashSet<>();

		if (s == null) {
			return new ArrayList<String>();
		}

		combinations(s.toCharArray(), 0, result);
		return new ArrayList<String>(result);
	}

	void combinations(char[] s, int start, Set<String> result) {
		if (start == s.length) {
			String value = String.valueOf(s);
			if (!result.contains(value)) {
				result.add(value);				
			}

		} else {
			for (int i = start; i < s.length; i++) {
				swap(s, i, start);
				combinations(s, start + 1, result);
				swap(s, i, start);
			}
		}
	}

	void swap(char[] s, int i, int j) {
		char tmp = s[i];
		s[i] = s[j];
		s[j] = tmp;
	}
    
}
