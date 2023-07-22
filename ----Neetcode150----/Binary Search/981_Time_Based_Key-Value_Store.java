import java.util.HashMap;
import java.util.List;

class TimeMap {
    // note that one of the constraints is "All the timestamps timestamp of set are
    // strictly increasing"
    // time complexity of set: O(1); time complexity of get: O(logn)

    HashMap<String, List<Pair<String, Integer>>> map;// Pair<Key Type, Value Type>

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        String res = "";
        List<Pair<String, Integer>> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).getValue() <= timestamp) {
                res = list.get(mid).getKey();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
