//GFG => https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
// dfs
import java.util.*;

class Solution {

    public boolean isCycleDFS(List<Integer>[] adj, int u, boolean[] visited, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;
        
        for (int v : adj[u]) {
            if (!visited[v] && isCycleDFS(adj, v, visited, inRecursion))
                return true;
            else if (inRecursion[v])
                return true;
        }
        
        inRecursion[u] = false;
        return false;
    }
    
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCycleDFS(adj, i, visited, inRecursion))
                return true;
        }
        
        return false;
    }
}

// BFS
// KAHN'S ALGORITHM

class Solution {
    // Function to detect cycle in a directed graph
    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> que = new LinkedList<>();
        int[] indegree = new int[N];
        int count = 0;
        
        // 1. Calculate indegrees
        for (int u = 0; u < N; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }
        
        // 2. Fill queue with nodes having indegree 0
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                que.add(i);
                count++;
            }
        }
        
        // 3. Simple BFS
        while (!que.isEmpty()) {
            int u = que.poll();
            
            for (int v : adj.get(u)) {
                indegree[v]--;
                
                if (indegree[v] == 0) {
                    que.add(v);
                    count++;
                }
            }
        }

        // if count is equal to number of nodes then there was no cycle but if it is not equal then cycle was detected
        return count != N;
    }
}
