// GFG => https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int INF = (int)1e8;
        int[] result = new int[V];
        Arrays.fill(result, INF);
        result[src] = 0;

        // Relax edges V - 1 times
        for (int i = 1; i <= V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (result[u] != INF && result[u] + w < result[v]) {
                    result[v] = result[u] + w;
                }
            }
        }

        // Check for negative weight cycle by doing one more pass from V-1 to V
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (result[u] != INF && result[u] + w < result[v]) {
                return new int[]{-1};
            }
        }

        return result;
        
    }
