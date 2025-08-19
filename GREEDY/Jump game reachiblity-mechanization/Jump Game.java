// leetcode => https://leetcode.com/problems/jump-game/description/
//https://leetcode.com/problems/jump-game/solutions/5130181/video-move-goal-position
class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0; 
    }
}
