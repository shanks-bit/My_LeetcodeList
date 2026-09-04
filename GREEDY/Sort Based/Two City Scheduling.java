// https://leetcode.com/problems/two-city-scheduling

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int[][] diff = new int[n][2];

        for (int i = 0; i < n; i++) {
            diff[i][0] = costs[i][0] - costs[i][1]; // cost difference A vs B
            diff[i][1] = i;                          // remember original index
        }

        Arrays.sort(diff, (a, b) -> a[0] - b[0]);

        int cost = 0;
        for (int i = 0; i < n / 2; i++) {
            cost += costs[diff[i][1]][0]; // cheapest-to-switch half → City A
        }
        for (int i = n / 2; i < n; i++) {
            cost += costs[diff[i][1]][1]; // rest stay in City B
        }

        return cost;
    }
}
/*
For every person i, compute diff[i] = costs[i][0] - costs[i][1], and remember their original index.
Sort people by diff in ascending order.
The first n/2 people (smallest diff → A is cheapest relative to B) fly to City A, paying costs[i][0].
The remaining n/2 people stay in City B, paying costs[i][1].
Sum it all up.
*/
