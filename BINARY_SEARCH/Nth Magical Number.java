//leetcode => https://leetcode.com/problems/nth-magical-number/

class Solution {
    // Define modulus constant for the problem
    private static final int MOD = (int) 1e9 + 7;

    // Utility method to calculate the greatest common divisor using Euclid's algorithm
    private int gcd(int a, int b) {
        // Recursive calculation of gcd
        return b == 0 ? a : gcd(b, a % b);
    }
    
    public int nthMagicalNumber(int n, int a, int b) {
        // Calculate least common multiple of a and b using gcd (Greatest Common Divisor)
        int leastCommonMultiple = a * b / gcd(a, b);    

        // Initialize binary search bounds
        long lowerBound = 0;
        long upperBound = (long) (a + b) * n;

        // Binary search to find the smallest number that is the nth magical number
        while (lowerBound < upperBound) {
            // Middle of the current bounds
            long mid = (lowerBound + upperBound) >>> 1;

            // Check if the mid number is a valid magical number by counting
            // all multiples of a and b up to mid, minus those of their lcm to avoid double-counting
            if (mid / a + mid / b - mid / leastCommonMultiple >= n) {
                // If count is equal or greater than n, we shrink the right bound
                upperBound = mid;
            } else {
                // Otherwise, we need to look for a larger number
                lowerBound = mid + 1;
            }
        }
        // After binary search, lower bound is our nth magical number
        // Return it modulo MOD
        return (int) (lowerBound % MOD);
    }
}
