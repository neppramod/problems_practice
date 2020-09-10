import java.util.*;

class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String secret = "11";
		String guess = "10";
		System.out.println(sol.getHint(secret, guess));
	}

	
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null || secret.length() == 0 || guess.length() == 0) {
            return "";
        }
        
        int a = 0;
        int b = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();  // put all charactes from secret
        for (int i = 0; i < secret.length(); i++) {
            char sc = secret.charAt(i);
            if (!map.containsKey(sc)) {
                map.put(sc, 1);
            } else {
                map.put(sc, map.get(sc) + 1);
            }
        }
        
        HashSet<Integer> matchedPositions = new HashSet<>();
        
        // Count only matched characters
        for (int i = 0; i < secret.length(); i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);
            
            if (sc == gc) {
                matchedPositions.add(i);
                a++;
                Integer count = map.get(sc);
                
                if (count != null) {
                    if (count == 1) {
                        map.remove(sc);
                    } else {
                        map.put(sc, count - 1);
                    }
                }
            }
        }
        
        
        // Now try to find other characters in map from guess
        for (int i = 0; i < guess.length(); i++) {
            char gc = guess.charAt(i);
            
            Integer count = map.get(gc);
            
            if (count != null) {
                if (matchedPositions.contains(i)) {
                    continue;
                }
                
                b++;
                if (count == 1) {
                    map.remove(gc);
                } else {
                    map.put(gc, count - 1);
                }
            }
        }
        
        
        
        
        
        return a + "A" + b + "B";
    }
}
