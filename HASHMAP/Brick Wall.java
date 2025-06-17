// leetcode -> https://leetcode.com/problems/brick-wall/description/
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sol = wall.size();
        for (List<Integer> row : wall) 
        {
            
            int sum = 0;
            //last space has no value as everything ends there
            for (int i=0; i<row.size()-1; i++) 
            {
                sum += row.get(i);
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                }
                else {
                    map.put(sum, 1);
                }
            }
            
            for (int key: map.keySet())
            {
                sol = Math.min(sol, wall.size() - map.get(key));
            }
            
        }
        return sol;
    }
}
//o(n)->time , o(m)->space (map have m values)
