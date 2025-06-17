// leetcode -> https://leetcode.com/problems/longest-consecutive-sequence/description/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num: nums) {
            numSet.add(num);
        }
        int longest = 0;
        for (int num: numSet) {
            //If num - 1 is NOT in the set, the contains method returns false, and the ! negates it to true, so the if block will run.

            //If num - 1 is in the set, the contains method returns true, the ! negates it to false, and the if block will be skipped.
            // it will find lowest no. and start counting from  there
            if (!numSet.contains(num - 1)) {
                int curr = num;
                int len = 1;

                while (numSet.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                longest = Math.max(longest, len);
            }
        }
        return longest;
    }
}
// o(n) - time
