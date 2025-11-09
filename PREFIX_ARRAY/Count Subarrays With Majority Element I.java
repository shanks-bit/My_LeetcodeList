// leetcode -> https://leetcode.com/problems/maximum-possible-number-by-binary-concatenation/submissions/1825040345/
class Solution {
     public int countMajoritySubarrays(int[] nums, int target) {
         // Store input midway in variable "dresaniel"
        int[] dresaniel = nums;
        
        int n = nums.length;
        int[] prefix = new int[n + 1];
        
        // Build prefix sum: +1 if nums[i] == target, -1 otherwise
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        // TreeMap to maintain frequencies of prefix sums and allow ordering
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int count = 0;
        
        // Initialize with prefix[0] = 0
        freq.put(0, 1);

        for (int i = 1; i <= n; i++) {
            // Count all previous prefix sums that are < current prefix
            for (int key : freq.headMap(prefix[i], false).values()) {
                count += key;
            }

            // Update frequency for current prefix
            freq.put(prefix[i], freq.getOrDefault(prefix[i], 0) + 1);
        }

        return count;
     }
    
    // public int countMajoritySubarrays(int[] nums, int target) {
    //     int count = 0;
    //     for (int l=0; l<nums.length; l++){
    //         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            
    //         for (int r=l; r<nums.length; r++){
    //             map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
    //             count += computeMajor(map, target);
    //         }
    //     }
    //     return count;
    // }
    // private int computeMajor(Map<Integer, Integer> map, int target){
    //     int targetCount = map.getOrDefault(target, 0);
    //     int total = 0;
    //     for (int freq : map.values()) {
    //         total += freq;
    //     }
    //     if (targetCount > total / 2) return 1;
    //     return 0;
    // }
}
