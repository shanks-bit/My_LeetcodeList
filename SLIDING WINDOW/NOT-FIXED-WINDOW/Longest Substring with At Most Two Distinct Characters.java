// leetcode => https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
class Solution {
    private final int allowedLen = 2;
        
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // [character, number of repetiotion]
        Map<Character, Integer> map = new HashMap();
        
        int left = 0; // start of the window
        int right = 0; // end of the window
        int max = 0;
        
        while(right < s.length()) {
            if(map.size() <= allowedLen) {  
                // add new charater from the end pointer
                Character newChar = s.charAt(right);
                map.put(newChar, map.getOrDefault(newChar, 0) + 1); // increase the counter if we face this character
                
                // increase the size of window
                right++;
            } else {
                // decrease the size of the window as far as we've reached the number of distinct characters at most two
                // remove left character
                Character charToRemove = s.charAt(left);

                int counter = map.get(charToRemove) - 1;
                if(counter < 1) {
                    // there are no such characters in a row. Let's delete the character from the map
                    map.remove(charToRemove);
                } else {
                    // update counter
                    map.put(charToRemove, counter);
                }
                left++;
            }
            
            // if we stil in the right amount of distinct characters calculate maximus
            if(map.size() <= allowedLen) {  
                max = Math.max(max, (right - left) + 0);
            }
        }
        
        return max;
    }
}
