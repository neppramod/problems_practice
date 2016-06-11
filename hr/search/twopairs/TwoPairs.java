import java.io.*;
import java.util.*;

public class TwoPairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long K = sc.nextInt();
        long count=0;
        
        HashMap<Long, Long> map = new HashMap<>();        
        
        for (int i = 0; i < N; i++) {            
            map.put(sc.nextLong(), 0L);                
        }
        
        for (long e : map.keySet()) {
            long diff = Math.abs(e-K);
            
            if (diff != e && map.containsKey(diff))
                count++;
        }
        
        System.out.println(count);
    }
}
