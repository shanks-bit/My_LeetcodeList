// GFG => https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1

class Pair {
    int node;
    int weight;
    
    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
    
    public String toString() {
        return "{" + this.node + ", " + this.weight + "}";
    }
}

class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Firstly create the graph using edges array
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            // Add bidirectional edges as the graph is undirected
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        
        // Giving minimum distance to node 'i'
        int[] dist = new int[n+1];
        // Giving parent of node 'i'
        int[] parent = new int[n+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0; // '1' is the source node
        for(int i=0; i<=n; i++) {
            // Initially parent of each node is itself
            parent[i] = i;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pair(1, 0));
        
        // Remove top of pq, check its neighbours, if a lesser distance is possible to
        // reach them, update the dist[], parent[] and add a new Pair to pq
        while(!pq.isEmpty()) {
            Pair top = pq.remove();
            int currNode = top.node;
            int currWeight = top.weight;
            
            for(Pair i: adj.get(currNode)) {
                int newWeight = currWeight + i.weight;
                if(newWeight < dist[i.node]) {
                    dist[i.node] = newWeight;
                    parent[i.node] = currNode;
                    pq.add(new Pair(i.node, newWeight));
                }
            }
        }
        
        // Backtrack the parent list of nth node
        List<Integer> res = new ArrayList<>();
        int node = n;
        while(node != parent[node]) {
            res.add(node);
            node = parent[node];
        }
        
        // Check the parent of last element in res, if its '1', we found a possible
        // shortest path, if not return a list with -1
        if(res.size() == 0 || parent[res.get(res.size() - 1)] != 1) {
            res.clear();
            res.add(-1);
            return res;
        }
        res.add(1);
        res.add(dist[n]);
        Collections.reverse(res);
        return res;
    }
}
