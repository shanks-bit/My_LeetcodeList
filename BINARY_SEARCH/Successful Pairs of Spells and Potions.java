//leetcode => https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] pairs = new int[n];

        for(int i = 0; i < n; i++){
            int l = 0, r = m-1;
            int ans = 0;
            while(l <= r){
                int mid = l + (r-l)/2;
                long strength = (long)spells[i] * (long)potions[mid];
                if(strength >= success){
                    ans = mid;
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            pairs[i] = m - l;
        }
        return pairs;
    }    
}
