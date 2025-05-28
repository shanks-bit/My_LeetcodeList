//  leetcode => https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        PriorityQueue<int[]> maxPq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // max-heap
        PriorityQueue<int[]> minPq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // min-heap

        int i = 0; // Left boundary of the sliding window
        int j = 0; // Right boundary of the sliding window
        int maxLength = 0;

        while (j < n) {
            maxPq.offer(new int[]{nums[j], j});
            minPq.offer(new int[]{nums[j], j});

            while (maxPq.peek()[0] - minPq.peek()[0] > limit) {
                i = Math.min(maxPq.peek()[1], minPq.peek()[1]) + 1;

                while (maxPq.peek()[1] < i) {
                    maxPq.poll();
                }
                while (minPq.peek()[1] < i) {
                    minPq.poll();
                }
            }

            // Update maxLength with the length of the current valid window
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }
}
