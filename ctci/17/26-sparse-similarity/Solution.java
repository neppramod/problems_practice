import java.util.*;

public class Solution
{
    /**
       Map document content to document no. it is present in. Count intersection, union the two documents taking into consideration of intersection(count once) and find the similarity
     */

    private static HashMap<Integer, ArrayList<Integer>> valueMapper(HashMap<Integer, ArrayList<Integer>> documentContents)
    {
        HashMap<Integer, ArrayList<Integer>> valueMap = new HashMap<Integer, ArrayList<Integer>>();
        for (Integer documentNo : documentContents.keySet()) {
            ArrayList<Integer> documentValues = documentContents.get(documentNo);

            for (Integer documentValue : documentValues) {
                if (!valueMap.containsKey(documentValue)) {
                    ArrayList<Integer> newKeyList = new ArrayList<Integer>();
                    newKeyList.add(documentNo);
                    valueMap.put(documentValue, newKeyList);
                } else {
                    valueMap.get(documentValue).add(documentNo);
                }
            }
        }

        return valueMap;
    }

    private static int intersection(Integer document1, Integer document2, HashMap<Integer, ArrayList<Integer>> valueMap)
    {
        int count = 0;
        
        for (Integer valueKey : valueMap.keySet()) {
            ArrayList<Integer> documentList = valueMap.get(valueKey);
            if (documentList.contains(document1) && documentList.contains(document2))
                count++;
        }

        return count;
    }

    private static int union(Integer document1, Integer document2, HashMap<Integer, ArrayList<Integer>> documentContents, int intersectionCount)
    {
        int count = 0;
        
        count += documentContents.get(document1)!= null ? documentContents.get(document1).size() : 0;
        count += documentContents.get(document2)!= null ? documentContents.get(document1).size() : 0;
        count -= intersectionCount;

        return count;
    }
    
    private static double similarity(int intersectionCount, int unionCount)
    {
        return (unionCount == 0 || intersectionCount == 0) ? 0 : intersectionCount / (double)unionCount;
    }
    
    public static void main(String[] args)
    {
        // prepare documents with values
        HashMap<Integer, ArrayList<Integer>> documentContents = new HashMap<Integer, ArrayList<Integer>>();
        
        documentContents.put(13, new ArrayList<>(Arrays.asList(14, 15, 100, 9, 3)));
        documentContents.put(16, new ArrayList<>(Arrays.asList(32, 1, 9, 3, 5)));
        documentContents.put(19, new ArrayList<>(Arrays.asList(15, 29, 2, 6, 8, 7)));
        documentContents.put(24, new ArrayList<>(Arrays.asList(7, 10)));
        
        ArrayList<Integer> documentKeys = new ArrayList<>(documentContents.keySet());
        HashMap<Integer, ArrayList<Integer>> valueMap = valueMapper(documentContents);
        
        while(documentKeys.size() > 0) {
            int cur = documentKeys.remove(0);
            
            for (int remKey : documentKeys) {
                int intersectionCount = intersection(cur, remKey, valueMap);
                
                if (intersectionCount > 0) {
                    int unionCount = union(cur, remKey, documentContents, intersectionCount);
                    System.out.println(cur + ", " + remKey + "  : " + similarity(intersectionCount, unionCount));
                }
            }
        }
    }
}
