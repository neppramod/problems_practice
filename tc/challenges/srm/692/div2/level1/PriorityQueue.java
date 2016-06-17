public class PriorityQueue
{
    public int findAnnoyance(String S, int[] a)
    {
	if (S == null || a == null || a.length != S.length())
            return 0;

	int[] sum = new int[a.length];
        int cursum = 0;
        int total = 0;

        for (int i = 1; i <= a.length - 1; i++) {
            cursum+= a[i-1];

            if (S.charAt(i) == 'b') {
                total += cursum;
            }
        }

        return total;
    }

    public static void main(String[] args)
    {
        PriorityQueue pq = new PriorityQueue();
        System.out.println(pq.findAnnoyance("bbbbb", new int[] {1,1,1,1,1}));
        System.out.println(pq.findAnnoyance("bbeebeebeeeebbb", new int[]{58,517,301,524,79,375,641,152,810,778,222,342,911,313,336} ));
        
    }
}
