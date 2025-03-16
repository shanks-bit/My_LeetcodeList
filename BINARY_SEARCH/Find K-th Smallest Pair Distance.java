// leetcode => https://leetcode.com/problems/find-k-th-smallest-pair-distance/solutions/5634256/runtime-3ms-binary-search-sliding-window/

class Solution {
    private int getPairs(int t, int[] nums) {
        int cnt = 0;
        for (int l = 0, r = 1; r < nums.length; r++) {
            while (l < r && t < nums[r] - nums[l]) {
                l++;
            }
            cnt += r - l;
        }
        return cnt;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getPairs(mid, nums) < k) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}

// Approach

//     Sorting the Array: Start by sorting the array. This helps in efficiently finding the distance between pairs since a sorted array guarantees that smaller differences appear first.

//     Binary Search on Distance: Use binary search to guess the possible value of the k-th smallest distance. The search range for possible distances will be between 0 (the minimum possible distance) and the difference between the maximum and minimum elements in the array.

//     Counting Pairs with getPairs: For a mid-value during the binary search, count how many pairs have a distance less than or equal to this mid-value. This is done by iterating through the array with a two-pointer approach.

//     Adjusting the Search Range:
//         If the count of pairs with a distance less than or equal to the current mid is less than k, it means the k-th smallest distance must be larger, so adjust the lower bound.
//         Otherwise, adjust the upper bound.

//     Result: The binary search will converge on the k-th smallest distance.

// Complexity

//     Time Complexity:
//         Sorting the array: O(nlogn)
//         Binary search on distance: O(logD) where D is the difference between the maximum and minimum elements.
//         Counting pairs: O(n) for each iteration of binary search.
//         Overall: O(nlogn+nlogD)

//     Space Complexity: O(1), not considering the input array.
