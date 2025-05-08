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
