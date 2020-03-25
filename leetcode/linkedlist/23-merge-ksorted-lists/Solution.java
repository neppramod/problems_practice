import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        ListNode[] lists = new ListNode[3];
        lists[0] = c(1);
        lists[0].next = c(4);
        lists[0].next.next = c(5);

        lists[1] = c(1);
        lists[1].next = c(3);
        lists[1].next.next = c(4);

        lists[2] = c(2);
        lists[2].next = c(6);

        ListNode node = mergeKLists(lists);
        printNode(node);
    }

    /*
      create class with
      key, index in list array, nextIndex
      Add to priority queue, sorted by key
      Get the value from priority queue, add the value to result,
      Change the key to next item in current index array, if next is null, don't add back to pr
     */

    static class Track implements Comparable<Track>
    {
        int key;
        int currentRow;
        ListNode nextElement;

        public int compareTo(Track t1) {
            return key - t1.key;
        }

        public Track(int k, int curRow, ListNode nextEle) {
            key = k;
            currentRow = curRow;
            nextElement = nextEle;
        }
    }

    static void printNode(ListNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printNode(root.next);
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Track> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(new Track(lists[i].val, i, lists[i].next));
            }
        }

        ListNode node = c(-1);
        ListNode head = node;

        while (!pq.isEmpty()) {
            Track track = pq.poll();
            //System.out.println(track);
            node.next = c(track.key);
            node = node.next;

            if (track.nextElement != null) {
                track.key = track.nextElement.val;
                track.nextElement = track.nextElement.next;
                pq.add(track);
            }
        }

        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static ListNode c(int x) {
        ListNode node = new ListNode(x);
        return node;
    }

}
