public class IsUnique01
{
    static boolean isUnique(String str)
    {
        boolean[] foundchar = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            if (foundchar[str.charAt(i)])
                return false;
                
            foundchar[str.charAt(i)] = true;
        }
        
        return true;    
    }

    public static void main(String[] args)
    {
        System.out.println(isUnique("apple"));
        System.out.println(isUnique("mouse"));
    }
}
