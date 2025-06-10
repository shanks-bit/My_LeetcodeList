// leetcode -> https://leetcode.com/problems/boats-to-save-people/description/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1, res = 0;

        while (left <= right) {
            int remain = limit - people[right--];
            res++;

            if (left <= right && remain >= people[left]) {
                left++;
            }
        }
        return res;
    }
}
