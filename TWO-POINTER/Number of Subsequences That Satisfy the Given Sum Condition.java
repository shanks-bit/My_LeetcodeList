// leetcode -> https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/

//better solution
class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        
        // Precompute the value of 2 to the power of each value.
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; ++i) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        
        int answer = 0;
        int left = 0, right = n - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                answer += power[right - left];
                answer %= mod;
                left++;
            } else {
                right--;
            }
        }
        
        return answer;
    }
}
------------------------------------------------------------------------------------------------------------
class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);    //Sorting so that we can get the min and max directly

        int i=0, j=nums.length-1, count=0, mod=(int)1e9 + 7;

        int[] power=new int[nums.length];  //Calculating the power in the power array.
        power[0]=1; // no. of subsequences formed using one no. is 1

        for(int idx=1;idx<nums.length;idx++)
            power[idx]=(power[idx-1]*2)%mod;  
			//Now if i is at 0 and j is at 3 then the no. of 
			//subsequences keeping the first no. that is at i fixed we can form 8 subsequences, similarly for different values of i and j the no. of subsequences varies.
			// if this is the array
		    // 3 5 6 7			
		    // i     j                      j-i=3.
		    // then no. of subsequences formed keeping 3 constant is 8 which is stored in the power array (power[j-i]=8) just do a dry run of the formula. you will get 8 for gap of 3
			//3
			//3 5 6 7
			//3 5 6
			//3 5 7
			//3 6 7
			//3 5
			//3 6
			//3 7
        while(i<=j){
            if(nums[i]+nums[j]<=target){
                count=(count+power[j-i])%mod;
                i++;
            }else if(nums[i]+nums[j]>target)
                j--;
        }
        return count;
    }
}
//Subsequences Formula:

//When nums[i]+nums[j]≤targetnums[i]+nums[j]≤target, the number of subsequences is 2j−i2j−i, leveraging the binary nature of inclusion/exclusion.
