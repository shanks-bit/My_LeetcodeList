// leetcoe => https://leetcode.com/problems/kth-largest-element-in-an-array/description/

//binary search
class Solution {
    
    static int count(int[] nums,int mid){
        int count=0;
        for(int i:nums){
            if(i>=mid) count++;
        }    
        return count;
    }
    
    public int findKthLargest(int[] nums, int k) {
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        int ans = -1;
        for(int i:nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        while(min <= max){
            int mid = min + (max - min)/2;
            if(count(nums,mid) < k){
                max = mid -1;
            }
            else{
                ans = mid;
                min = mid+1;
            }
        }
        return ans;
    }
}

//HEAP
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
