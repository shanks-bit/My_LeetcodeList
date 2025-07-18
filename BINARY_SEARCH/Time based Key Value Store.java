// leetcode -> https://leetcode.com/problems/time-based-key-value-store/description/

class TimeMap {
    HashMap<String, TreeMap<Integer, String>> keyTimeMap;
    
    public TimeMap() {
        keyTimeMap = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new TreeMap<Integer, String>());
        }
        
        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }
        
        Integer floorKey = keyTimeMap.get(key).floorKey(timestamp);
        // Return searched time's value, if exists.
        if (floorKey != null) {
            return keyTimeMap.get(key).get(floorKey);
        }
        
        return "";
    }
}
/*
Java has a little different implementation, here we will use thefloorKey method,
which returns a key equal to or less than searched key or null if no such key exists that satisfies the above condition.
*/
