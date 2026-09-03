// https://leetcode.com/problems/distant-barcodes/description/

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int code : barcodes) {
            freq.put(code, freq.getOrDefault(code, 0) + 1);
        }

        // Max-heap based on frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.add(new int[]{entry.getValue(), entry.getKey()});
        }

        int n = barcodes.length;
        int[] res = new int[n];
        int i = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int count = curr[0], val = curr[1];
            while (count-- > 0) {
                if (i >= n) i = 1;
                res[i] = val;
                i += 2;
            }
        }

        return res;
    }
}
