// leetcode => https://leetcode.com/problems/number-of-provinces/description/

class Solution {
    //dfs
    private int n;

    private void dfs(int[][] adj, int u, boolean[] visited) {
        visited[u] = true;

        // Visit neighbors
        for (int v = 0; v < n; v++) {
            if (adj[u][v] == 1 && !visited[v]) {
                dfs(adj, v, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, i, visited);
            }
        }

        return count;
    }

    //bfs
    private int n;
    
    private void bfs(int[][] adj, int u, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int v = 0; v < n; v++) {
                if (adj[node][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(isConnected, i, visited);
                count++;
            }
        }
        
        return count;
    }
}
