// leetcode => https://leetcode.com/problems/my-calendar-i/description/

//Approach 1
class MyCalendar {

    // List to store the booked intervals
    List<int[]> calendar;

    public MyCalendar() {
        // Initialize the list
        calendar = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        // Check for overlap with every existing booking
        for (int[] curr : calendar) {
            // If there is overlap, return false
            if (!(end <= curr[0] || start >= curr[1])) {
                return false;
            }
        }

        // If no overlap, add the booking to the calendar
        calendar.add(new int[]{start, end});
        return true;
    }
}
/*
Approach: 2

    TreeMap is used because it sorts its keys in natural order (in Integer that order would be ascending)
    TreeMap is also used because of the higherEntry method. HigherEntry returns the next bigger key (compared to the value given, in this case, "start") from the map.
    HigherEntry() example: TreeMap: {1=One, 2=Two, 3=Three, 4=Four, 5=Five} --> The higherEntry value for 3 is 4=Four
    Important note, the map key is the end time and the value is the start time. */

class MyCalendar {
    TreeMap<Integer,Integer> calendar = new TreeMap<>();
    public MyCalendar() {
        calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    public boolean book(int start, int end) {
        Map.Entry<Integer,Integer> pair = calendar.higherEntry(start);
        boolean res = end <= pair.getValue();
        if (res) calendar.put(end, start);
        return res;
    }
}
