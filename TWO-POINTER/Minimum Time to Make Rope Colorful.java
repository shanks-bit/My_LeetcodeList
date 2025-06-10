// leetcode -> https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int left = 0, time = 0;
        for (int right=1; right<colors.length(); right++) {

            if (colors.charAt(left) == colors.charAt(right)) {

                if (neededTime[left] < neededTime[right]) {
                    time += neededTime[left];
                    left = right;
                }
                else {
                    time += neededTime[right];
                }
            }
            else {
                left = right;
            }
        }
        return time;
    }
}
