// leetcode -> https://leetcode.com/problems/container-with-most-water/description/
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;

        while (l <= r) {
            int currentArea = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(maxArea, currentArea);

            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}
