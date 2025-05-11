// leetcode => https://leetcode.com/problems/minimum-deletions-for-at-most-k-distinct-characters/description/

class Solution {
    public int minDeletion(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;

        for( char c : s.toCharArray()) {
            map.put( c, map.getOrDefault(c, 0) + 1);
        }
        int length = map.size();

        if(length <= k) {
            return 0;
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int dis = list.size();
        int i = 0;
        while (dis > k) {
            result += list.get(i);
            dis--;
            i++;
        }
        return result;
    }
}
