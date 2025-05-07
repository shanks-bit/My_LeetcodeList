// GFG => https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
// we will pass parent in every function call and check if the element is visited but not the parent then it means it is cycle
//DFS
class Solution {
    // Function to detect cycle in an undirected graph.
    private boolean isCycleThere(int src, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis)
    {        
        vis[src] = true;        
        for (int child : adj.get(src))
        {
            if (!vis[child])
            {
                if (isCycleThere(child, src, adj, vis)) return true;
            }            
            else if (parent != child) return true;
        }        
        return false;
    }      
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) 
    {  // Code here        
        int n = adj.size();        
        boolean[] vis = new boolean[n];        
        for (int i = 0; i < n; i++)
        {
            if (!vis[i])
            {
                if (isCycleThere(i, -1, adj, vis)) return true;
            }
        }        
        return false;
    }
}

//BFS
class Solution 
{
    // Function to detect cycle in an undirected graph.        
    private boolean isCycleThere(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis)
    {
        Queue<int[]> que = new LinkedList<>();   
        que.offer(new int[] {src, -1});        
        vis[src] = true;       
        while (!que.isEmpty())
        {
            int size = que.size();            
            for (int i = 0; i < size; i++)
            {
                int[] curr = que.poll();                
                int child = curr[0];
                int parent = curr[1];                
                for (int node : adj.get(child))
                {
                    if (!vis[node])
                    {
                        vis[node] = true;
                        que.add(new int[] {node, child});
                    }
                    else if (parent != node)
                    {
                        return true;
                    }
                }
            }
        }        
        return false;        
    }    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) 
    {
        int n = adj.size();           
        boolean[] vis = new boolean[n];        
        for (int i = 0; i < n; i++)
        {
            if (!vis[i])
            {
                if (isCycleThere(i, adj, vis)) return true;
            }
        }        
        return false;
    }
}
