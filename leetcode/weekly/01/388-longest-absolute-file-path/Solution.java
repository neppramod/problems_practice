import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
		Solution sol = new Solution();

		int result = sol.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
		System.out.println(result);
    }
    
    

	public int lengthLongestPath(String input) {
		if (input.length() == 0) {
			return 0;
		}

		String[] lines = input.split("\n");
		String levels[] = new String[200];
		levels[0] = lines[0];

		List<String> list = new ArrayList<>();
		list.add(levels[0]);

		//		System.out.println(Arrays.toString(lines));
		
		for (int i = 1; i < lines.length; i++) {
			int tabs = countTabs(lines[i]);
			String rest = lines[i].trim();

			levels[tabs] = rest;

			String curDirStr = getDirStr(levels, tabs);
			list.add(curDirStr);
		}

		int max = 0;
		for (int i = 0; i < list.size(); i++) {
            String cur = list.get(i);
            if (cur.contains(".")) {
                max = Math.max(max, list.get(i).length());
            }
			
		}

		return max;
		
	}

	String getDirStr(String[] levels, int curLevel) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < curLevel; i++) {
			sb.append(levels[i]).append("/");
		}
		sb.append(levels[curLevel]);

		return sb.toString();
	}

	int countTabs(String s) {
			int tabs = 0;
			for (int k = 0; k < s.length(); k++) {
				if (s.charAt(k) == '\t') {
					tabs++;
				} else {
					break;
				}
			}

			return tabs;

	}
}
