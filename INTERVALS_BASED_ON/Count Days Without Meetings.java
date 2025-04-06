//leetcode => https://leetcode.com/problems/count-days-without-meetings/description/
class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        int result = 0;
        int end = 0;
        
        for (int[] meet : meetings) {
            // meet[0] => startDay, meet[1] => endDay => end
            if (meet[0] > end) {
                result += meet[0] - end - 1;
            }
            // as meetings overlap => [[1,5],[2,4]] => using below logic end would be 5 otherwise it would come 4 and would give improper result.
            end = Math.max(end, meet[1]);
        }
        
        //if free days left
        if (days > end) {
            result += days - end;
        }
        
        return result;
    }
}
