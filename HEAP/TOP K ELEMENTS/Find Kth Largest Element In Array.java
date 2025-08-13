//leetcode => https://leetcode.com/problems/kth-largest-element-in-an-array/description/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heapMin = new PriorityQueue<>();
        for (int i=0; i<k; i++) {
            heapMin.offer(nums[i]);
        }

        for (int i=k; i<nums.length; i++) {
            if (nums[i] > heapMin.peek()) {
                heapMin.poll();
                heapMin.offer(nums[i]);
            }
        }
        return heapMin.peek();
    }
}
