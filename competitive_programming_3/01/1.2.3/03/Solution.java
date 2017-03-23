/**
Given a date, determine the day of the week (Monday, ... Sunday)
*/

import java.util.*;
import java.text.*;

public class Solution {
    // yyyy-mm-dd
    public static int dayOfWeek(String dateStr) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        Date date = sdf.parse(dateStr);
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static void main(String[] args) {
        try {
            int dow = dayOfWeek("2015-06-17");
            System.out.println(Days.values()[dow - 1]);
        } catch(Exception ex) {
        }
    }

    enum Days {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};
}
