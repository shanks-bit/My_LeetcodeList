//leetcode -> https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/description/
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int n = nums.length;
        int left = 0, right = 0, max1 = 0, max2 = 0;
        int[] ans = new int[Math.max(0, n - k + 1)];

        for (right = 0; right < k; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
        }
        ans[0] = computeXSum(map, x);

        for (right = k; right < n; right++) {
            int add = nums[right];
            int rem = nums[right - k];

            map.put(add, map.getOrDefault(add, 0) + 1);
            int fr = map.get(rem) - 1;
            if (fr == 0) map.remove(rem);
            else map.put(rem, fr);

            ans[right - k + 1] = computeXSum(map, x);
        }

        return ans;
    }

    private int computeXSum(Map<Integer, Integer> freq, int x) {
        List<int[]> items = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            items.add(new int[]{e.getKey(), e.getValue()});
        }
        items.sort((a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            return b[0] - a[0];
        });
        long sum = 0;
        int take = Math.min(x, items.size());
        for (int i = 0; i < take; i++) {
            sum += 1L * items.get(i)[0] * items.get(i)[1];
        }
        return (int) sum;
    }
}
