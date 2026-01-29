// https://leetcode.com/problems/maximum-product-subarray/editorial/

class Solution {
    public int maxProduct(int[] nums) {
       // Initialize the maximum, minimum, and answer with the first element.
        // The max value 'maxProduct' represents the largest product found so far and
        // could be the maximum product of a subarray ending at the current element.
        // The min value 'minProduct' represents the smallest product found so far and
        // could be the minimum product of a subarray ending at the current element.
        // This is required because a negative number could turn the smallest value into 
        // the largest when multiplied by another negative number.
        int maxProduct = nums[0]; 
        int minProduct = nums[0];
        int answer = nums[0];      

        // Iterate through the array starting from the second element.
        for (int i = 1; i < nums.length; ++i) {
            // Store the current max and min before updating them.
            int currentMax = maxProduct;
            int currentMin = minProduct;      

            // Update the maxProduct to be the maximum between the current number, 
            // currentMax multiplied by the current number, and currentMin multiplied
            // by the current number. This accounts for both positive and negative numbers.
            maxProduct = Math.max(nums[i], Math.max(currentMax * nums[i], currentMin * nums[i]));         
            // Update the minProduct similarly by choosing the minimum value.
            minProduct = Math.min(nums[i], Math.min(currentMax * nums[i], currentMin * nums[i]));         
            // Update the answer if the newly found maxProduct is greater than the previous answer.
            answer = Math.max(answer, maxProduct);
        }     
        // Return the largest product of any subarray found.
        return answer; 
    }
}
