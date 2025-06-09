// leetcode -> https://leetcode.com/problems/maximize-ysum-by-picking-a-triplet-of-distinct-xvalues/
class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = y.length;
        Map<Integer, Integer> map = new HashMap<>();
        //step1 -> store the max value of the key in hashmap
        for (int i=0; i<x.length; i++) {
            map.put(x[i], Math.max(map.getOrDefault(x[i], 0), y[i]));
        }

        //step2 -> put values of map into list
        List<Integer> list = new ArrayList<>(map.values());
        if (list.size() < 3) return -1;

        //step3 -> sort list in desc 
        list.sort(Collections.reverseOrder());

        return (list.get(0) + list.get(1) + list.get(2));
    }
}
