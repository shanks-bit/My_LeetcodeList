// gfg => https://www.geeksforgeeks.org/problems/topological-sort/0
//DFS
import java.util.*;

class Solution {
    
    public void DFS(List<Integer>[] adj, int u, boolean[] visited, Stack<Integer> st) {
        visited[u] = true;
        
        // Visit all children first
        for (int v : adj[u]) {
            if (!visited[v]) {
                DFS(adj, v, visited, st);
            }
        }
        
        // Now push current node to stack
        st.push(u);
    }
    
    // Function to return list containing vertices in Topological order
    public List<Integer> topoSort(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(adj, i, visited, st);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        while (!st.isEmpty()) {
            result.add(st.pop());
        }
        
        return result;
    }
}
