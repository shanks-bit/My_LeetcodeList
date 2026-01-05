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
    class Solution {

    public void bfs(int node, int[][] isConnected, boolean[] visit) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;

        while (!q.isEmpty()) {
            node = q.poll();

            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[node][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                bfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }
}
