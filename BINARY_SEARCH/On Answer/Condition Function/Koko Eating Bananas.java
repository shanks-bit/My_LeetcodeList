//leetcode => https://leetcode.com/problems/koko-eating-bananas/description/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = (int) Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canEatAll(piles, mid, h)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canEatAll(int[] piles, int givenHours, int h) {
        int actualHours = 0;
        for (int x : piles) {
            actualHours += x / givenHours;

            if (x % givenHours != 0) {
                actualHours++;
            }        
        }
        return actualHours <= h;
    }
}
