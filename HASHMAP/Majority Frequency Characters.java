// leetcode -> https://leetcode.com/problems/majority-frequency-characters/description/

class Solution {
    public String majorityFrequencyGroup(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>
                                                                    ();
        char[] arr = new char[s.length()];
        int i=0;

        StringBuilder sol = new StringBuilder();
        int maxi = 0;
        for (char a : s.toCharArray()){
            map.put(a, map.getOrDefault(a,0)+1); 
            maxi = Math.max(maxi, map.get(a));        
        }

        Map<Integer, List<Character>> grp = new HashMap<>();
        for (Map.Entry<Character, Integer> ent : map.entrySet()) {
            int f = ent.getValue();
            grp.putIfAbsent(f, new ArrayList<>());
            grp.get(f).add(ent.getKey());
        } 

        int bestFreq = -1;
        List<Character> best = new ArrayList<>();
        for (Map.Entry<Integer, List<Character>> ent : grp.entrySet()) {
            int f = ent.getKey();
            List<Character> chars = ent.getValue();

            // Apply the winning conditions
            if (chars.size() > best.size() || 
            (chars.size() == best.size() && f > bestFreq)) {
                best = chars;
                bestFreq = f;
            }
        }

        for (char a : best){
            sol.append(a);
        }

        return sol.toString();
    }
}
