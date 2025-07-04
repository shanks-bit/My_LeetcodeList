//leetcode => https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/description/
// Approach-1 (By converting to intervals and finding the max intervals we can get)
// T.C : O(nlogn)
// S.C : O(n)

/* example
nums = [4,6,1,2], k = 2
[-1, 3], [0, 4], [2, 6], [4, 8]
🔹 Range: [-1, 3]
    Deque is empty → add 3
    Deque = [3]
    maxBeauty = 1
🔹 Range: [0, 4]
    3 (in deque) ≥ 0 → overlap
    Add 4 → Deque = [3, 4]
    maxBeauty = 2
🔹 Range: [2, 6]
    3 (in deque) ≥ 2 → overlap
    Add 6 → Deque = [3, 4, 6]
    maxBeauty = 3
🔹 Range: [4, 8]
    3 < 4 → remove 3 → Deque = [4, 6]
    4 ≥ 4 → still overlapping
    Add 8 → Deque = [4, 6, 8]
maxBeauty remains 3
*/
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // Convert nums into ranges
        List<int[]> ranges = new ArrayList<>();
        for (int num : nums) {
            ranges.add(new int[]{num - k, num + k});
        }

        // Sort the ranges based on their start point
        ranges.sort((a, b) -> Integer.compare(a[0], b[0]));

        int maxBeauty = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        // Iterate over sorted ranges
        for (int[] range : ranges) {
            while (!deque.isEmpty() && deque.peekFirst() < range[0]) {
                deque.pollFirst();
            }
            deque.offerLast(range[1]);

            maxBeauty = Math.max(maxBeauty, deque.size());
        }

        return maxBeauty;
    }
}
// Approach-2 (Sorting and Using Binary Search)
// T.C : O(nlogn)
// S.C : O(1)
class Solution {
    public int maximumBeauty(int[] nums, int k) {
/* 
After sorting, we use binary search for each number in the array to identify the largest value 
that does not exceed x+2k. If we find such a value at index j, and our current number is at index i, 
then j−i+1 represents the length of the possible subsequence. The maximum length found among all 
numbers in the array is our answer
*/
        Arrays.sort(nums);
        int maxBeauty = 0;

        // Proof in the video for nums[i] + 2*k
        for (int i = 0; i < nums.length; i++) {
            int upperBound = findUpperBound(nums, nums[i] + 2 * k);

            maxBeauty = Math.max(maxBeauty, upperBound - i + 1);
        }

        return maxBeauty;
    }

    private int findUpperBound(int[] nums, int target) {
        int low = 0, high = nums.length;
        int result = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return result;
    }
}


// Approach-3 (Using Sliding Window)
// T.C : O(nlogn)
// S.C : O(1)
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0, j = 0;
        int maxBeauty = 0;

        // Sliding window
        while (i < n) {
            while (j < n && nums[j] - nums[i] <= 2 * k) {
                j++;
            }

            maxBeauty = Math.max(maxBeauty, j - i);
            i++;
        }

        return maxBeauty;
    }
}
