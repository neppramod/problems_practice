/**
Given a date, determine the day of the week (Monday, ... Sunday)

Answer: Saturday
*/

import java.util.*;
import java.text.*;

public class Solution {
    public static int dayOfWeek(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal.get(Calendar.DAY_OF_WEEK);
        } catch (Exception ex) {}

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Days.values()[dayOfWeek("2015-08-15")-1]);
    }

    enum Days { Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday};
}
