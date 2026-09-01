// https://leetcode.com/problems/insert-interval/description/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        // 1. LEFT (non-overlapping)
        while (i < n && intervals[i][1] < newStart) {
            res.add(intervals[i]);
            i++;
        }

        // 2. MERGE (overlapping)
        while (i < n && intervals[i][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }
        res.add(new int[]{newStart, newEnd});

        // 3. RIGHT (remaining)
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
