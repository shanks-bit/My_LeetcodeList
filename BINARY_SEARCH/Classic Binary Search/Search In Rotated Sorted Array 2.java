//leetcode => https://leetcode.com/problems/single-element-in-a-sorted-array/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while( l < r){
            int m = l + r >>> 1;
            if(m % 2 == 1){   //m should be even to detect single element
                m -= 1;
            }
            if( nums[m] != nums[m + 1]){
                r = m;  //as m is changed for single element , now with this logic window can be closer to left
            }
            else{
                l = m + 2; //jumping double element
            }            
        }
        return nums[l];
    }
}
