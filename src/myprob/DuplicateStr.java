 import java.util.*;
 
 public class DuplicateStr
 { 
 	public void doSomething(char[] str) {
 		
 		for (int i = 0; i < str.length; i++) {
 			if (str[i] == -1)  {
 				continue;
 			}
 				
 			for (int j = i + 1; j < str.length; j++) { 
 				
	 			if (str[i] == str[j]) {
	 				str[j] = (char)-1;
	 			}
	 		}
 		}
 	} 
 	
 	public static void main(String[] args) {
 		char[] str = {'H', 'e', 'l', 'l', 'o'};
 		DuplicateStr duplicateStr = new DuplicateStr();
 		duplicateStr.doSomething(str);
 		System.out.println(Arrays.toString(str));
  	}
 }
