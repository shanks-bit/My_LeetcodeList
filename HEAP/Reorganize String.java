//leetcode => https://leetcode.com/problems/reorganize-string/description/
class Solution {
    public String reorganizeString(String S) {

        Map<Character, Integer> map = new HashMap<>();
        //map => character, count of the character
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            
            //condition if count of any character is more than a ((length of the string)+1) / 2 then adjacent pairs are not possible
            if (count > (S.length() + 1) / 2) 
                return "";
            
            map.put(c, count);
        }

        // max - heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        //heap => count of the character, character
        for (char c : map.keySet()) {
            pq.add(new int[] {map.get(c), c});
        }
        
        // Build the result.
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            int[] first  = pq.poll();
            int[] second = pq.poll();
            
            sb.append((char) first[1]);
            sb.append((char) second[1]);
            
            first[0]--;
            second[0]--;
            
            if(first[0] > 0)
                pq.add(first);
            
            if(second[0] > 0)
                pq.add(second);

        }
        //adding last one element if left after above condition
        if(!pq.isEmpty()) {
            int[] first  = pq.poll();
            
            sb.append((char) first[1]);
        }
        
        return sb.toString();
    }
}
