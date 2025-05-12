// leetcode => https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/

class Solution {
    private int[] parent;
    private int[] rank;

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
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) 
            return -1;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) 
            parent[i] = i; //apne aap ka parent

        int components = n; //abhi sab akele hai apne bharose

        for (int[] conn : connections) {
            if (find(conn[0]) != find(conn[1])) {  //if parent not equal so do union
                union(conn[0], conn[1]);
                components--;  //ilaka kam hoga union se
                
            }
        }
        return components - 1;
    }
}
