// leetcode => https://leetcode.com/problems/subarrays-with-k-different-integers/description/

class Solution {
    // Total count of subarrays having <= k distinct elements
    public int slidingWindow(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        int n = nums.length;
        int i = 0; 
        int j = 0;
        
        int count = 0;
        
        while(j < n) {
            
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            
            while(mp.size() > k) {
                // Shrink the window
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if(mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i++;
            }
            
            count += (j - i + 1); // Ending at j
            j++;
        }
        
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindow(nums, k) - slidingWindow(nums, k - 1);
    }
}
