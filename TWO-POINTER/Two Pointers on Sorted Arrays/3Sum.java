// leetcode -> https://leetcode.com/problems/3sum/description/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate elements for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int a = nums[i];
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int threeSum = a + nums[left] + nums[right];

                if (threeSum > 0) {
                    right--;
                } else if (threeSum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(a, nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicate elements for the second and third numbers
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
