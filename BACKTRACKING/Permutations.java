// leetcode => https://leetcode.com/problems/permutations/
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private Set<Integer> set = new HashSet<>();
    private int n;

    private void solve(List<Integer> temp, int[] nums) {
        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!set.contains(nums[i])) {
                temp.add(nums[i]);        //Add element
                set.add(nums[i]);

                solve(temp, nums);        //Explore element

                set.remove(nums[i]);      //Remove element
                temp.remove(temp.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        solve(new ArrayList<>(), nums);
        return result;
    }
}
