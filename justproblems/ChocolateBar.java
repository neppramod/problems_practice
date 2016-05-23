import java.util.*;

public class ChocolateBar
{
	// Figure out how many chocolate bars of 1x1 can be cut from in infinite WxL bar
	public static long numberOfBars(long cuts)
	{
		long i = cuts/2;
		long j = cuts - i;
		return i * j;
	}
	
	 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] inputarray = new int[T];
        for (int i = 0; i < T; i++) {
            inputarray[i] = sc.nextInt();            
        }
        
        for (int i = 0; i < T; i++) {
        	System.out.println(numberOfBars(inputarray[i]));
        }
    }
}
