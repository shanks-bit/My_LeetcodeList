// gfg => https://www.geeksforgeeks.org/maximum-subarray-size-subarrays-size-sum-less-k/

import java.util.*;

class GfG {

    // Function to find the maximum subarray
    // size such that all subarrays of that
    // size have sum less than or equals to k.
    static int maxSubarraySize(int[] arr, int k) {
        int n = arr.length;
        
        // initialize the low and high pointers
        int low = 1, high = n;
        
        // perform binary search 
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            // to store the sum of the subarray
            int sum = 0;
            
            // to store the max sum of all 
            // possible subarrays of size mid
            int maxSum = Integer.MIN_VALUE;
            
            for(int i = 0; i < n; i++) {
                sum += arr[i];  // Add current element to the sum
                
                if(i >= mid) {   // Remove the element that is out of the window
                    sum -= arr[i - mid];
                }
                
                if(i >= mid - 1) {  //// Update max sum once the window size reaches 'mid'
                    maxSum = Math.max(maxSum, sum);
                }
            }
            
            if(maxSum <= k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        if(high == 0)
            return -1;
        return high;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 8;
        System.out.println(maxSubarraySize(arr, k));
    }
}
