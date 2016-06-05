public class EllysTimeMachine
{
    public String getTime(String time)
    {
        String[] splittedTime = time.split(":");
        int hr = Integer.parseInt(splittedTime[0].trim());
        int min = Integer.parseInt(splittedTime[1].trim());
        int newhr = min / 5;
        int newmin = hr * 5;

        String hrstr = String.format("%02d", newhr);

        if (min == 0)
            hrstr = "12";
        
        String newminstr = String.format("%02d", newmin);
        return hrstr + ":" + newminstr;
    }

    public static void main(String[] args)
    {
        EllysTimeMachine etm = new EllysTimeMachine();
        System.out.println(etm.getTime("01:00"));
    }
}
