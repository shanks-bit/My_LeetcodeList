// leetcode -> https://leetcode.com/problems/merge-intervals/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merging = new LinkedList<>();
        for(int[] interval: intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if(merging.isEmpty() || merging.getLast()[1] < interval[0]) {
                merging.add(interval);
            }
            else {
                merging.getLast()[1] = Math.max(merging.getLast()[1],interval[1]);
            }
        }
        return merging.toArray(new int[merging.size()][]);
    }
}
