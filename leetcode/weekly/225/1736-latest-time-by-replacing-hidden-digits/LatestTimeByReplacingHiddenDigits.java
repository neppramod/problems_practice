import java.util.*;

public class LatestTimeByReplacingHiddenDigits {
    public static void main(String[] args) {
	    LatestTimeByReplacingHiddenDigits sol = new LatestTimeByReplacingHiddenDigits();
		
	}
	
    public String maximumTime(String time) {
	    char[] times = time.toCharArray();

		// if not ? we don't need to replace
		// if second is 3 or lesss like 23 hour, first can be 2, else safe to put 1
		// so that we don't end up with something like 29 hour
		if (times[0] == '?') {
			times[0] = times[1] <= '3' || times[1] == '?' ? '2' : '1';
		}

		// put the max based on times[0]
		// if times[0] is 2, we can only put 23
		// you don't want to put 9 when times[0] is '2'
		// since we are getting the latest time, we maximize everything if we can
		if (times[1] == '?') {
			times[1] = times[0] == '2' ? '3' : '9';
		}

		if (times[3] == '?') {
			times[3] = '5';
		}

		if (times[4] == '?') {
			times[4] = '9';
		}

		return new String(times);
    }
}
