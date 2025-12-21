// leetcode -> https://leetcode.com/problems/minimum-deletion-cost-to-make-all-characters-equal/description/
class Solution {
    public long minCost(String s, int[] cost) {
        HashMap<Character,Long>mapCost = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            mapCost.put(c, mapCost.getOrDefault(c,0L)+cost[i]);
        }

        ArrayList<Character> l = new ArrayList<>(mapCost.keySet());

        // sort keys using values
        Collections.sort(l,(a,b)->
                Long.compare(mapCost.get(a), mapCost.get(b)));

        long sum=0;
        for(int i=0; i<l.size()-1; i++){
            sum += mapCost.get(l.get(i));
        }

        return sum;
    }
}
