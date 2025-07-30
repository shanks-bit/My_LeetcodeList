// leetcode => https://leetcode.com/problems/min-cost-to-connect-all-points/description/

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        // Min-heap to store minimum weight edge at top.
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));;
        
        // Track nodes which are included in MST.
        boolean[] inMST = new boolean[n];
        
        heap.add(new Pair(0, 0));
        int mstCost = 0;
        int edgesUsed = 0;
        
        while (edgesUsed < n) {
            Pair<Integer, Integer> topElement = heap.poll();
            
            int weight = topElement.getKey();
            int currNode = topElement.getValue();
            
            // If node was already included in MST we will discard this edge.
            if (inMST[currNode]) {
                continue;
            }
            
            inMST[currNode] = true;
            mstCost += weight;
            edgesUsed++;
            
            for (int nextNode = 0; nextNode < n; ++nextNode) {
                // If next node is not in MST, then edge from curr node
                // to next node can be pushed in the priority queue.
                if (!inMST[nextNode]) {
                    int nextWeight = Math.abs(points[currNode][0] - points[nextNode][0]) + 
                                     Math.abs(points[currNode][1] - points[nextNode][1]);
        
                    heap.add(new Pair(nextWeight, nextNode));
                }
            }
        }
        
        return mstCost;
    }
}
----------------------------------------------------------------------------
class Solution {
    static class Pair implements Comparable<Pair> {
        int weight;
        int node;

        Pair(int weight, int node) {
            this.weight = weight;
            this.node = node;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the complete graph using Manhattan distance
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adj.get(i).add(new Pair(d, j));
                adj.get(j).add(new Pair(d, i));
            }
        }

        return minMST(adj, V);
    }

    private static int minMST(List<List<Pair>> adj, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] inMST = new boolean[V];
        int sum = 0;

        pq.offer(new Pair(0, 0)); // weight, node

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int wt = current.weight;
            int node = current.node;

            if (inMST[node]) continue;

            inMST[node] = true;
            sum += wt;

            for (Pair neighbor : adj.get(node)) {
                if (!inMST[neighbor.node]) {
                    pq.offer(new Pair(neighbor.weight, neighbor.node));
                }
            }
        }

        return sum;
    } 
}
