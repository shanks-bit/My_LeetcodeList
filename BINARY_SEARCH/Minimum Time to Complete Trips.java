//leetcode => https://leetcode.com/problems/minimum-time-to-complete-trips/description/

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1, right = (long) Arrays.stream(time).min().getAsInt() * totalTrips; 

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (countTrips(time, mid, totalTrips)) {  //true condition
                right = mid;
            }
            else {
                left = mid + 1;   //false condition
            }
        }
        return left;
    }

    private boolean countTrips(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;

        for (int t : time) {
            actualTrips += givenTime / t;
        }

        return actualTrips >= totalTrips;
    }
}
