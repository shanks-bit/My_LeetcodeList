// leetcode => https://leetcode.com/problems/ugly-number-iii/description/

class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ca = lcm(c, a);
        long abc = lcm(ab, c);
        long l = 1;
        long r = 2000000000;

        while(l < r){
            long mid = (l + r) >>> 1;
            if(count(mid,a,b,c,ab,bc,ca,abc) >= n){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return (int)l;
    }
    private long count(long mid,long a,long b, long c,long ab,long bc, long ca,long abc){
        long count_a = mid/a;
        long count_b = mid/b;
        long count_c = mid/c;
        long count_ab = mid/ab;
        long count_bc = mid/bc;
        long count_ca = mid/ca;
        long count_abc = mid/abc;
        return(count_a + count_b + count_c - count_ab - count_bc - count_ca + count_abc);
    }
    private long lcm(long a, long b) {
        long gcd = gcd(a, b);
        return gcd * (a/gcd) * (b/gcd);
    }
    private  long gcd(long a, long b) {
        if (a < b) {
            long t = a;
            a = b;
            b = t;
        }
        while ( b != 0) {
            long n = a % b;
            a = b;
            b = n;
        }

        return a;
    }
}
