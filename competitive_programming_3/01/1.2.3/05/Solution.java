/**
Given a distinct and valid birthdates of n people as triples (DD, MM, YYYY), order them first by ascending birth months (MM),
then by ascending birth dates (DD), and finally by ascending age.

[2015-02-15, 2010-03-06, 2012-09-15]
[2010-03-06, 2015-02-15, 2012-09-15]
[2010-03-06, 2012-09-15, 2015-02-15, ]
*/
import java.util.*;
import java.text.*;

public class Solution
{
    public static void main(String[] args) {
        String[] birthDates = {"2015-02-15", "2010-03-06", "2012-09-15"};

        List<String> birthDatesList = Arrays.asList(birthDates);

        // MM
        birthDatesList.sort((String x, String y) -> { return compareSubInt(x,y, 5, 7);});
        System.out.println(birthDatesList);


        // DD
        birthDatesList = Arrays.asList(birthDates);
        birthDatesList.sort((x,y) -> compareSubInt(x, y, 8, 10));
        System.out.println(birthDatesList);

        // Age
        Date[] birthDatesDtFmt = getDtFromDateStringList(birthDates);
        List<Date> birthDatesListDt = Arrays.asList(birthDatesDtFmt);
        birthDatesListDt.sort((x,y) -> x.compareTo(y));
        printDates(birthDatesListDt, "yyyy-MM-dd");
    }

    private static int compareSubInt(String x, String y, int startIndex, int endPastIndex) {
        String xS = x.substring(startIndex, endPastIndex);
        String yS = y.substring(startIndex, endPastIndex);

        int xI = Integer.parseInt(xS);
        int yI = Integer.parseInt(yS);

        return xI - yI;
    }

    private static Date[] getDtFromDateStringList(String[] birthDatesDtFmt) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date[] birthDates = new Date[birthDatesDtFmt.length];
        try {
            for (int i = 0; i < birthDates.length; i++) {
                birthDates[i] = sdf.parse(birthDatesDtFmt[i]);
            }
        } catch (Exception ex){}

        return birthDates;
    }

    private static void printDates(List<Date> dates, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        System.out.print("[");
        dates.forEach(x -> {
                System.out.print(sdf.format(x) + ", ");
        });
        System.out.println("]");
    }
}
