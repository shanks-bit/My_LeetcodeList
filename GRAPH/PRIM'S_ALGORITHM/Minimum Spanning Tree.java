// GFG => https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        int[] visited = new int[V];
        Arrays.fill(visited, 0);
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        // Add {weight, node, parent}
        pq.add(new int[]{0, 0, -1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int wt = curr[0];
            int node = curr[1];

            if (visited[node] == 1) continue;

            visited[node] = 1;
            ans += wt;

            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];

                if (visited[adjNode] == 0) {
                    pq.add(new int[]{edgeWeight, adjNode, node});
                }
            }
        }
        return ans;
    }
}
