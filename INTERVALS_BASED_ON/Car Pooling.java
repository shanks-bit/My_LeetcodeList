//leetcode => https://leetcode.com/problems/car-pooling/description/
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Initialize an array to record the cumulative changes in passenger count at each stop.
        int[] passengerChanges = new int[1001];


        // Iterate over all trips to record passenger pick-ups and drop-offs.
        for (int[] trip : trips) {
            int numberOfPassengers = trip[0]; // The number of passengers for the trip
            int startLocation = trip[1];      // The starting location for the trip
            int endLocation = trip[2];        // The ending location for the trip
          

            // Add the number of passengers to the start location
            passengerChanges[startLocation] += numberOfPassengers;

            // Subtract the number of passengers from the end location
            passengerChanges[endLocation] -= numberOfPassengers;
        }     

        // Initialize the current number of passengers in the car to 0.
        int currentPassengers = 0;     

        // Iterate over each location to update the number of passengers after each pick-up/drop-off.
        for (int change : passengerChanges) {
            currentPassengers += change; // Update the current number of passengers.
         
            // If the current number of passengers exceeds capacity, return false.
            if (currentPassengers > capacity) {
                return false;
            }
        }     
        // If we've successfully accounted for all trips without exceeding capacity, return true.
        return true;
    }
}
