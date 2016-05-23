import java.util.*;
import java.lang.*;
import java.io.*;

class UnionOfTwoArraysSetList  {
	public static void main (String[] args) {
	    
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		List<Set<Integer>> listSet = new ArrayList<>();
		
		for (int i = 0; i < T; i++) {
		    int N = sc.nextInt();
		    int M = sc.nextInt();
		    
		    Set<Integer> set = new HashSet<Integer>();
		    for (int j = 0; j < N; j++) {
		        set.add(sc.nextInt());
		    }
		    
		    for (int j = 0; j < M; j++) {
		        set.add(sc.nextInt());
		    }
		    
		    listSet.add(set);
		}
		
		for (Set<Integer> set : listSet) {
		    List<Integer> mylist = new ArrayList<Integer>(set);
		    Collections.sort(mylist);
		    
		    for (Integer val : mylist) {
		        System.out.print(val + " ");    
		    }
		    System.out.println();
		}
		
	}
}
