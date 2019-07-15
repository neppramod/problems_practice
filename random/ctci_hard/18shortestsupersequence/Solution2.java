import java.util.*;

public class Solution2
{
    public static void main(String[] args) {

        int[] largerArray = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] smallerArray = {5, 9, 1};

        ArrayList<Queue<Integer>> scannedIndices = scanSmallerElementsInLargerArray(largerArray, smallerArray);
        Range range = getShortestClosure(scannedIndices);
        System.out.println(range);

    }

    private static ArrayList<Queue<Integer>> scanSmallerElementsInLargerArray(int[] largerArray, int[] smallerArray)
    {
        HashMap<Integer, Queue<Integer>> smallerIndicesListMap = new HashMap<>();
        for (int s : smallerArray) {
            smallerIndicesListMap.put(s, new LinkedList<Integer>());
        }

        for (int i = 0; i < largerArray.length; i++) {
            Queue<Integer> smallerQueue = smallerIndicesListMap.get(largerArray[i]);
            if (smallerQueue != null) {
                smallerQueue.add(i);
            }
        }

        ArrayList<Queue<Integer>> smallerIndicesList = new ArrayList<>();
        smallerIndicesList.addAll(smallerIndicesListMap.values());

        return smallerIndicesList;
    }

    private static class Range
    {
        int startIndex;
        int closureIndex;

        public Range(int startIndex, int closureIndex) { this.startIndex = startIndex; this.closureIndex = closureIndex; }
        public boolean shorterThan(Range otherRange) { return this.closureIndex - this.startIndex < otherRange.closureIndex - otherRange.startIndex; }
        public String toString() { return startIndex + " : " + closureIndex; }
    }


    private static Range getShortestClosure(ArrayList<Queue<Integer>> scannedIndices)
    {
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>((x,y) -> (y.listId - y.index) -  (x.listId - x.index) );
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < scannedIndices.size(); i++) {
            Queue<Integer> queue = scannedIndices.get(i);
            int currentIndex = queue.remove();  // remove

            minHeap.add(new HeapNode(currentIndex, i));
            max = Math.max(max, currentIndex);
        }



        Range minRange = new Range(0, Integer.MAX_VALUE);
        while(true) {

            HeapNode currentNode = minHeap.poll();

            Range currentRange = new Range(currentNode.index, max);
            if (currentRange.shorterThan(minRange)) minRange = currentRange;

            Queue<Integer> nextQueueToAddFrom = scannedIndices.get(currentNode.listId);
            if (nextQueueToAddFrom.size() == 0) break;

            // remove the element from queue and add to minHeap
            int item = nextQueueToAddFrom.remove();
            minHeap.add(new HeapNode(item, currentNode.listId));



            max = Math.max(max, item);
        }

        return minRange;
    }

    private static class HeapNode
    {
        int index;
        int listId;

        public HeapNode(int index, int listId) { this.index = index; this.listId = listId; }

        /*
        public boolean equals(Object obj)
        {
            HeapNode node = (HeapNode) obj;
            return node.index == index && node.listId == listId;
        }

        public int hashCode()
        {
            return Objects.hash(index, listId);
        }


        public String toString() {
            return "index: " + index + ", listId: " + listId;
        }
        */

    }

}
