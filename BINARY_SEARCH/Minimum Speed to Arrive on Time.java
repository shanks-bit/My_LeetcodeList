//leetcode => https://leetcode.com/problems/minimum-speed-to-arrive-on-time/description/

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = (int) 1e7;
        int minSpeed = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (possible(dist, mid) <= hour) {
                minSpeed = mid;
                right = mid-1;
            } else {
                left = mid + 1; // Need to speed up
            }
        }

        return minSpeed;
    }
    public double possible(int[] dist, int speed) {
        double time = 0.0;
        int n = dist.length;

        for (int i = 0; i < n - 1; i++) {
            double t = (double) dist[i] / (double) speed;
            time += Math.ceil(t);
        }
       
       //last time can be taken in doubal form
        time += (double) dist[n - 1] / (double) speed;

        return time;
    }
}
