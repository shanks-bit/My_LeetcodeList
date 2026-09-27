// https://leetcode.com/problems/longest-subarray-with-restricted-pair-sums/description/
/*
If my starting position is l and I am expaning towards right. If I encounter a r such that my subarray becomes invalid 
- all subsequent subarray will be invalid as well.

That means, Now I have to move my l to again make the array valid if I add nums[r].
This tells us that we can use a sliding window and check:
If I add nums[r], will my current subarray become invalid?
That's the whole intuition.
Now, to avoid repeatedly checking the whole range [l, r], we keep track of the frequency of each element.
Since nums[i] is in [1, 500], we only need a frequency array of size 501.
If we are adding nums[r] = x, there are two ways in which x can be part form a invalid triplet.

Case 1: x is the sum
a + b = x
We can iterate over a from 1 to 500 and calculate:
b = x - a
If b exists in the frequency array, we found a bad triplet.
We just need to handle the case a == b separately because the indices must be distinct.

Case 2: x is one of the values
a + x = b
For every a, calculate:
b = a + x
If b is between 1 and 500 and exists in the frequency array, we found a bad triplet.
So we use the above checks in a helper function to determine whether adding nums[r] makes the window invalid.
Approach
    Use a helper isInvalid(freq, x) to check whether adding x creates a bad triplet.
    Check both cases:
        a + b = x
        a + x = b
    Use a sliding window with l and r.
    Before adding nums[r], check if it makes the current window invalid.
    If it is invalid, move l forward and remove nums[l] from the frequency array.
    Once it becomes valid, add nums[r] to the frequency array and update the answer.
*/
class Solution {
    private boolean isInvalid(int[] p, int x) {
        // if I add x, will my subarray be valid or not? 
        for(int d = 1; d <= 500; d++) {
            if(p[d] == 0) continue; 
            // if x is sum a + b = x 
            int other = x - d; 
            if(other >= 0 && other <= 500) {
                // other valid
                if(other == d && p[d] >= 2) return true; 
                if(other != d && p[other] > 0) return true; 
            }


            // if x is one of value, a + x = b
            int t = x + d; 
            if(t >= 0 && t <= 500) {
                if(p[t] > 0) return true; 
            }
        }
        return false; 
    }
    public int maxSubarray(int[] nums) {
        // pair sum should be btw [0, 500] for to be valid. 

        // Starting from and start index `l` we can find till when we have valid pair. 
        // If we get a invalid pair after adding some index r, then subsequent arrays are not valid. that means move `l` now and again find till it's valid. 
        int l = 0, r = 0; 
        int n = nums.length; 
        int ans = 0; 
        int p[] = new int[501]; 
        
        for(int i = 0; i < n; i++) {
            while(l < i && isInvalid(p, nums[i])) {
                p[nums[l]]--; 
                l++; 
            }
            p[nums[i]]++; 
            ans = Math.max(ans, i - l + 1); 
        }
    
        return ans; 
    }
}
