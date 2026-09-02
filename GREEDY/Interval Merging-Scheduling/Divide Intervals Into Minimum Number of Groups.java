// https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/description/

class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int[] interval : intervals) {

        // Because intervals are inclusive,
        // we can reuse a group ONLY if its end < current start.
        if (!pq.isEmpty() && pq.peek() < interval[0]) {
            pq.poll();
        }

        // Current interval occupies a group until interval[1]
        pq.offer(interval[1]);
    }

    return pq.size();
    }
}
//Minimum number of groups = maximum number of intervals that overlap at the same point.
