// https://leetcode.com/problems/maximum-equal-adjacent-pairs-after-at-most-one-replacement/description/
/*
We need maximum no of adjacent pairs which are equal after at most 1 transformation.
Let's take a step back and observe first.

Case 1 - If we have a pair of type (x, x) ? what happens to it if the value change??
It becomes (y, y) but it is still a pair.

Case 2 - If it's of type (x, y) or (y, x) -> then I can change any one of them. See both (x, y) or (y, x) will becomes 
same if I change a value right?? That means they both are counted as same.
    (2, 3) & (3, 2) -> both either becomes (2, 2) or (3, 3) depending on change.
That means, we have to maximize the (x, y) pairs now and we replace any one value among them. Correct??
That's it!!
Approach
    Find all adjacent pairs = initial_pairs
    Put all (x, y) pairs in Hashmap or anything of your pref
    We use HashMap<Key, Integer> where key = (x, y) - x < y. (why? so that both (x,y) & (y, x) counted as same)
    add all pairs to hashmap where x != y. (x = nums[i], y = nums[i-1])
    Find teh pair with max frequency = best.
    ans = best + initial_pairs.
*/
class Solution {
    private record Key(int a, int b) {}
    public int maxEqualAdjacentPairs(int[] nums) {
        int cnt = 0;
        int n = nums.length; 
        HashMap<Key, Integer> mp = new HashMap<>();  
        for(int i = 1; i < n; i++) {
            if(nums[i] == nums[i -1]) cnt++; 
            else {
                // add it to mp 
                Key key;  
                if(nums[i] < nums[i - 1]) {
                    key = new Key(nums[i], nums[i-1]); 
                } else key = new Key(nums[i-1], nums[i]);
                mp.put(key, mp.getOrDefault(key, 0) + 1); 
            }
        }
        int best = 0; 
        // Now the pair with most freq will give us best answer on changing 
        for(Integer val: mp.values()) {
            best = Math.max(best, val); 
        }
        return cnt + best; 
    }
}
