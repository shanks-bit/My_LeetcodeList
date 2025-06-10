// leetcode -> https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/description/
class Solution {
    public int minimumLength(String s) {
        int left = 0, right = s.length()-1, holder = 0;

        while (s.charAt(left) == s.charAt(right) && left < right) {
            holder = s.charAt(left);
            left++;
            right--;
            while (holder == s.charAt(left) && left <= right) {
                left++;
            }
            while (holder == s.charAt(right) && left <= right) {
                right--;
            }
        }
        return right - left + 1;
    }
}
