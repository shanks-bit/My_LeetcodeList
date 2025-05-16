// letcode => https://leetcode.com/problems/network-delay-time/description/

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] time : times) {
            adj.computeIfAbsent(time[0], v -> new ArrayList<>())
            .add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator
        .comparingInt(a -> a[0]));
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[k] = 0;
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

            if (d > result[node]) continue;

            if (adj.containsKey(node)) {
                for (int[] neighbor : adj.get(node)) {
                    int adjNode = neighbor[0];
                    int dist = neighbor[1];

                    if (d + dist < result[adjNode]) {
                        result[adjNode] = d + dist;
                        pq.offer(new int[]{d + dist, adjNode});
                    }
                }
            }
        }

        int ans = Arrays.stream(result, 1, n + 1).max().orElse(Integer.MAX_VALUE);
        return ans == Integer.MAX_VALUE ? -1 : ans; 
    }
}
