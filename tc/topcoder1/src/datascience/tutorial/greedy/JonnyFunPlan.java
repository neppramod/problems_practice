/*
  Activity selection problems
*/

import java.util.*;

public class JonnyFunPlan
{
    private static class Activity implements Comparable
    {
        Date start;
        Date finish;

        public Activity(Date s, Date f) { start = s; finish = f; }
        public int compareTo(Object o) {
            Activity a = (Activity) o;
            return finish.compareTo(a.finish);
        }
    }

    public ArrayList<Activity> selectedActivities(ArrayList<Activity> allActivities)
    {
        // Sort according to acending order of finish time
        Collections.sort(allActivities);

        ArrayList<Activity> selected = new ArrayList<Activity>();
        if (allActivities.size() == 0) return selected;
        selected.add(allActivities.get(0));

        Activity j = allActivities.get(0);
        for (int k = 1; k < allActivities.size(); k++) {
            Activity i = allActivities.get(k);
            if (i.start.compareTo(j.finish) >= 0) {
                selected.add(i);
                j = i;
            }
        }

        return selected;
    }

    public static void main(String[] args)
    {

    }

    private static ArrayList<Activity> prepareList() {
        return null;
    }
}
