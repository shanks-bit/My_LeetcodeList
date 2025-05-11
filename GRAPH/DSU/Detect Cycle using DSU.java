// GFG => https://www.geeksforgeeks.org/problems/detect-cycle-using-dsu/1



class Solution
{
    private int[] parent;
    private int[] rank;
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        parent = new int[V];
        rank = new int[V];
        // Code here
        for (int i = 0; i < V; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                if (u < v) { // To avoid duplicate edge checking
                    if (find(u) == find(v)) {
                        return 1; // true
                    } else {
                        union(u, v);
                    }
                }
            }
        }
        return 0; //false
    }
    public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]); // Path compression
        }
    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) return;

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
}
