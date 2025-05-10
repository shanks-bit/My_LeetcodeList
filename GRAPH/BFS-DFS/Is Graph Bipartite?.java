// leetcode => https://leetcode.com/problems/is-graph-bipartite/description/
    //dfs       
    private boolean checkBipartiteDFS(int[][] adj, int u, int[] color, int currColor) {
       
        color[u] = currColor;        

        for(int v : adj[u]) {
            if(color[v] == color[u]){ //means same color
                return false;
            }
            if(color[v] == -1) {

                int colorOfV = 1 - currColor; // Assign opposite color
                if(!checkBipartiteDFS(adj,v,color, colorOfV)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] adj) {//only 2 types of color can be filled
        int n = adj.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);        

        for(int i=0; i<n; i++) {
            if(color[i] == -1) { //not coloured
                if(!checkBipartiteDFS(adj,i,color,1)){
                    return false;
                }     
            }
        }
        return true;
    }

 //bfs
    
    private boolean checkBipartiteBFS(int[][] adj, int start, int[] color, int currColor) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = currColor; // Start coloring with 1
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            for (int v :adj[u]) {                
                if (color[v] == color[u]) {
                    return false; // Conflict found
                }
                if (color[v] == -1) { // If uncolored
                    color[v] = 1 - color[u]; // Assign opposite color
                    queue.add(v);
                }                
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] adj) { // Only two types of colors can be filled
        int n = adj.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // Initialize all nodes as uncolored
        
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) { // If not colored, start BFS
                if (!checkBipartiteBFS(adj, i, color, 1)) {
                    return false;
                }
            }
        }
        return true;
    }
