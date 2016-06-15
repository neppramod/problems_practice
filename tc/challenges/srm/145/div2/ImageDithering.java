import java.util.*;

public class ImageDithering
{
    public int count(String dithered, String[] screen)
    {        

        HashMap<String, Integer> map = new HashMap<>();
        String[] ditheredcolors = dithered.split("");
        for (String dc : ditheredcolors) {
        	map.put(dc, 0);
        }
	
    	return getdetheredcount(map, screen);   
    }
    
    private int getdetheredcount(HashMap<String, Integer> map, String[] screen)
    {
    	int count = 0;
    	
    	for (int i = 0; i < screen.length; i++) {
    		String[] scline = screen[i].split("");
    		
    		for (int j = 0; j < scline.length; j++) {
    			if (map.containsKey(scline[j])) {
    				count++;
    			}
    		}
    	}
    	
    	return count;
    }   
}
