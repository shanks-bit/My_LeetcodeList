// leetcode -> https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i/description/

class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int[] newPattern = new int[nums.length - 1];

        //Find the pattern of the nums array
        for(int i = 0 ; i < nums.length - 1 ; i++) {
            if(nums[i] < nums[i + 1]) {
                newPattern[i] = 1;
            } else if(nums[i] == nums[i + 1]) {
                newPattern[i] = 0;
            } else {
                newPattern[i] = -1;
            }
        }

        //Find the occurrences of the pattern in the pre-computed       
        //numsPattern
        int count = 0;
        for(int i = 0 ; i <= newPattern.length - pattern.length ; i++) {
            if(isEquals(newPattern, i, 
                            i + pattern.length - 1, pattern)) 
            {
                count++;
            }
        }
        
        return count;
    }

    boolean isEquals(int[] newPattern , int i , int j, int[] pattern) {
        for(int x = i ; x <= j ; x++) {
            if(newPattern[x] != pattern[x - i]) {
                return false;
            }
        }
        return true;
    }
}
