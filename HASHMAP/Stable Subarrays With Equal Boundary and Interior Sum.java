// leetcode -> https://leetcode.com/problems/stable-subarrays-with-equal-boundary-and-interior-sum/

class Solution {
    public long countStableSubarrays(int[] a) {
        long n = a.length, res = 0, pre = 0;
        // value → (prefixSum → frequency)
        Map<Long, Map<Long, Long>> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {

            if (mpp.containsKey((long)a[i])) {
                Map<Long, Long> t = mpp.get((long)a[i]);
                Long cnt = t.get(pre - a[i]);
                if (cnt != null) res += cnt;
            }

            pre += a[i];
            Map<Long, Long> t = mpp.computeIfAbsent((long)a[i], 
                                            k -> new HashMap<>());
            t.put(pre, t.getOrDefault(pre, 0L) + 1L);

            /* When consecutive zeros appear (e.g., [0,0,0]), the counting logic can double-count short 
              overlapping subarrays.This correction subtracts 1 to prevent overcounting in such cases. */
            if (i > 0 && a[i] == 0 && a[i - 1] == 0) res--; 
        }

        return res;
    }
}
