import java.util.*;
 
public class CombinationIterator
{
    public static void main(String[] args) {
		CombinationIterator iterator = new CombinationIterator("abc", 2);
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		
    }
    
    List<String> combinations = new ArrayList<>();
    int currentCounter = 0;

    public CombinationIterator(String characters, int combinationLength) {
        if (characters == null || characters.length() < combinationLength) {
            return;
        }
        
        int totalCount = (int)Math.pow(2, characters.length());
        
        for (int i = 0; i < totalCount; i++) {
            int setBits = getSetBits(i);
            
            if (setBits == combinationLength) {
                StringBuilder sb = new StringBuilder();
               for (int j = 0; j < 32; j++) {
                   if ((i & (1 << j)) != 0) {
                       sb.append(characters.charAt(j));
                   }
               }
                
               combinations.add(sb.toString());  
            }
        }

		Collections.sort(combinations);
    }

	int getSetBits(int i) {
		int count = 0;
		for (int j = 0; j < 32; j++) {
			if ((i & (1 << j)) != 0) {
				count++;
			}
		}
		return count;
	}
    
    public String next() {
        if (currentCounter < combinations.size()) {
            return combinations.get(currentCounter++);
        } else {
            return null;
        }
    }
    
    public boolean hasNext() {
        return currentCounter < combinations.size();
    }
}
