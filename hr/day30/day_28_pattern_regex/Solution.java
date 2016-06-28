import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<String> nameList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String firstName = sc.next();
            String email = sc.next();

            if (email.contains("@gmail.com")) {
                nameList.add(firstName);
            }
        }

        Collections.sort(nameList);
        for (String name : nameList) {
            System.out.println(name);
        }
    }
}


