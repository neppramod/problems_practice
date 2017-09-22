import java.util.*;

public class Mixtures
{
    public static int minSmoke(ArrayList<Integer> mixtures)
        {
            if (mixtures.size() < 2) return 0;

            int s = 0;
            while(mixtures.size() >= 3) {
                int m1 = mixtures.remove(0);
                int m2 = mixtures.remove(0);
                int m3 = mixtures.remove(0);

                int t11 = 0, t12 = 0, s11 = 0, s12 = 0;
                int t21 = 0, t22 = 0, s21 = 0, s22 = 0;

                t11 = (m1 + m2) % 100;
                t12 = (t11 + m3) % 100;
                s11 = m1 * m2;
                s12 = t11 * m3;

                t21 = (m2 + m3) % 100;
                t22 = (t21 + m1) % 100;
                s21 = m2 * m3;
                s22 = t21 * m1;

                s += Math.min(s11 + s12, s21 + s22);
                mixtures.add(0, Math.min(t12, t22));
            }

            if (mixtures.size() == 2)
                s = mixtures.get(0) * mixtures.get(1);

            return s;
        }

    public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);

            ArrayList<Integer> mixtures = new ArrayList<>();
            int N = sc.nextInt();
            for (int j = 0; j < N; j++) {
                mixtures.add(sc.nextInt());
            }
            System.out.println(minSmoke(mixtures));

        }
}
