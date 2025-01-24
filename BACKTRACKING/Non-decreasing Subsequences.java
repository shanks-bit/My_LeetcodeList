//leetcode => https://leetcode.com/problems/non-decreasing-subsequences/

class Solution {
    private int n;
    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(nums, 0, curr, result);

        return result;
    }

    private void backtrack(int[] nums, int idx, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() > 1) {
            result.add(new ArrayList<>(curr));
        }

        Set<Integer> st = new HashSet<>();
        for (int i = idx; i < n; i++) {
            if ((curr.isEmpty() || nums[i] >= curr.get(curr.size() - 1)) && !st.contains(nums[i])) {
                curr.add(nums[i]);  //Add element
                backtrack(nums, i + 1, curr, result);  //Explore element
                curr.remove(curr.size() - 1);  //Remove element

                st.add(nums[i]);
            }
        }
    }
}
