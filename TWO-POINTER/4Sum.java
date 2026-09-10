// https://leetcode.com/problems/4sum/description/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n - 3; i++) {

            for (int j = i + 1; j < n - 2; j++) {

                long newTarget =
                    (long) target - nums[i] - nums[j];

                int low = j + 1;
                int high = n - 1;

                while (low < high) {

                    long sum =
                        (long) nums[low] + nums[high];

                    if (sum < newTarget) {
                        low++;
                    }
                    else if (sum > newTarget) {
                        high--;
                    }
                    else {

                        set.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[low],
                            nums[high]
                        ));

                        low++;
                        high--;
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}
