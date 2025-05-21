// GFG => https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
/*
Kosaraju’s Algorithm:

    Step1 :  Sort All nods on their finishing time using 
                 topological sort.

    STEP 2 : Transpose the graph means change the direction of eges between every U and V.

    Step 3 : Make DFS call on transpose graph with the help of topological sort order Stack elemtnt 
    Return the cnt 
*/
class Solution {
    // Function to find number of strongly connected components in the graph.
    private void dfsFill(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfsFill(v, adj, visited, st);
            }
        }

        st.push(u);
    }

    private void dfsTraverse(int u, ArrayList<ArrayList<Integer>> adjReversed, boolean[] visited) {
        visited[u] = true;

        for (int v : adjReversed.get(u)) {
            if (!visited[v]) {
                dfsTraverse(v, adjReversed, visited);
            }
        }
    }

    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();  // Determine number of vertices from the adjacency list
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];

        // Step 1: Fill the stack with vertices by finish time
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsFill(i, adj, visited, st);
            }
        }

        // Step 2: Reverse the graph
        ArrayList<ArrayList<Integer>> adjReversed = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjReversed.add(new ArrayList<>());
        }

        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                adjReversed.get(v).add(u);
            }
        }

        // Step 3: Process all vertices in order defined by the stack
        Arrays.fill(visited, false);
        int count = 0;

        while (!st.isEmpty()) {
            int node = st.pop();
            if (!visited[node]) {
                dfsTraverse(node, adjReversed, visited);
                count++;
            }
        }

        return count;
    }
}
