//leetcode=> https://leetcode.com/problems/minimize-maximum-of-array/description/

class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        int maxL = 0;
        int maxR = Arrays.stream(nums).max().getAsInt();
        int result = 0;
        
        while (maxL <= maxR) {
            int midMax = maxL + (maxR - maxL) / 2;
            
            if (isValid(nums, midMax, n)) {
                result = midMax;
                maxR = midMax - 1;
            } else {
                maxL = midMax + 1;
            }
        }
        
        return result;
    }

    private boolean isValid(int[] nums, int midMax, int n) {
        long[] arr = Arrays.stream(nums).mapToLong(i -> i).toArray();
        
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > midMax) {
                return false;
            }
            
            long buffer = midMax - arr[i];
            arr[i + 1] -= buffer;
        }
        
        return arr[n - 1] <= midMax;
    }
}
