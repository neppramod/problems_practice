/*
  Shortest super sequence:
  Find the range of integers in smaller array in larger array of integers, in any order

  E.g.

  {1, 5, 9}
  {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}

  Ans: Indices 7:10 => {5, 7, 9, 1}


  We need to find closure: Maximum of the indices of larger array where smaller array was found

  In above array 1 is the last element that need to be found for valid closure, because 5 and 9 are after that

 */
import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        int[] largerArray = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] smallerArray = {5, 9, 1};
        int[] closures = findClosures(largerArray, smallerArray);
        Range shortestSuperSequence = getShortestClosure(closures);
        System.out.println(shortestSuperSequence);
    }

    private static class Range
    {
        int startIndex;
        int closureIndex;

        public Range(int startIndex, int closureIndex) { this.startIndex = startIndex; this.closureIndex = closureIndex; }
        public boolean shorterThan(Range otherRange) { return this.closureIndex - this.startIndex < otherRange.closureIndex - otherRange.startIndex; }
        public String toString() { return startIndex + " : " + closureIndex; }
    }

    private static int[] findClosures(int[] largerArray, int[] smallerArray)
    {
        int[] closures = new int[largerArray.length];
        for (int i = 0; i < smallerArray.length; i++) {
            scanForClosure(largerArray, closures, smallerArray[i]);
        }

        return closures;
    }

    private static Range getShortestClosure(int[] closures)
    {
        Range shortest = new Range(0, closures[0]);
        for (int i = 1; i < closures.length; i++) {
            if (closures[i] == -1) break;
            Range currentRange = new Range(i, closures[i]);
            if (currentRange.shorterThan(shortest)) shortest = currentRange;
        }

        return shortest;
    }

    private static void scanForClosure(int[] largerArray, int[] closures, int smallerValue)
    {
        int next = -1;
        for (int i = largerArray.length-1; i >= 0; i--) {
            if (largerArray[i] == smallerValue) next = i;

            if ((next == -1 || closures[i] < next ) && (closures[i] != -1)) closures[i] = next;
        }
    }

}
