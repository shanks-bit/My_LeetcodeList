//leetcode => https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/description/

// Line Sweep Algorithm
/*
This approach is similar to the previous one but uses a method called the Line Sweep algorithm. It's useful for solving problems
involving intervals.
The Line Sweep algorithm tracks when intervals start and end. For each interval (start, end), we mark the start by increasing the count
at start by 1 (indicating a new interval starts), and we mark the point end + 1 by decreasing its count by 1 (indicating an interval ends). 
These changes are stored in a map, which keeps track of how many intervals start or end at each point.
After processing all the intervals, we calculate a running total (prefix sum) over the map. This running total shows how many intervals 
are active at any given point. The highest value of this total tells us the minimum number of groups needed to avoid overlap.
*/

class Solution {

    public int minGroups(int[][] intervals) {
        // Use a TreeMap to store the points and their counts
        TreeMap<Integer, Integer> pointToCount = new TreeMap<>();

        // Mark the starting and ending points in the TreeMap
        for (int[] interval : intervals) {
            pointToCount.put(
                interval[0],
                pointToCount.getOrDefault(interval[0], 0) + 1
            );
            pointToCount.put(
                interval[1] + 1,
                pointToCount.getOrDefault(interval[1] + 1, 0) - 1
            );
        }

        int concurrentIntervals = 0;
        int maxConcurrentIntervals = 0;

        // Iterate over the entries of the TreeMap in ascending order of keys
        for (Map.Entry<Integer, Integer> entry : pointToCount.entrySet()) {
            concurrentIntervals += entry.getValue(); // Update currently active intervals
            maxConcurrentIntervals = Math.max(
                maxConcurrentIntervals,
                concurrentIntervals
            ); // Update max intervals
        }

        return maxConcurrentIntervals;
    }
}
//end+1 as as it is picking end point  also
    
//Priority Queue
class Solution {
    public int minGroups(int[][] intervals) {
        // Sort intervals based on the starting times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Priority Queue (min-heap) to store the end points of the groups and here the one that we want to compare the new pair its start would be compared with end in min heap and store the the end in it
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Iterate through the intervals
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // If the top of the queue (smallest end time) is smaller than the current start time
            // we can merge the interval into an existing group, so we pop the earliest end time
            if (!pq.isEmpty() && pq.peek() < start) {
                pq.poll();
            }

            // Add the current interval's end time to the queue (new or updated group)
            pq.offer(end);
        }

        // The size of the priority queue will give the number of groups needed
        return pq.size();
    }
}
