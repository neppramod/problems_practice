import java.util.*;

class Solution {
    public static int solution(int[] T) {
        /*
          Save count of all types into map
          she has to give away L = N/2

          when L >= 0, subtract from all map, count > 1

          if (L > 0) ans = remaining count - L
        */

        HashMap<Integer, Integer> typesCount = new HashMap<>();
        int N = T.length;
        for (int i = 0; i < N; i++) {
            if (!typesCount.containsKey(i)) {
                typesCount.put(i, 1);
            } else {
                typesCount.put(i, typesCount.get(i) + 1);
            }
        }

        int L = N/2;

        for (int key : typesCount.keySet()) {
            if (typesCount.get(key) > 1) {
                int cur = typesCount.get(key)-1;
                L = L-cur;
                typesCount.put(key, 1);
                if (L <= 0) break;
            }
        }

        int abc = 0;
        if (L > 0)  abc = N-L;

        if (abc > typesCount.keySet().size()) return typesCount.keySet().size();
        else return abc;


    }

    public static void main(String[] args)
    {
        int[] A = {3, 4, 7, 7, 6, 6};
        System.out.println(solution(A));
    }
}
