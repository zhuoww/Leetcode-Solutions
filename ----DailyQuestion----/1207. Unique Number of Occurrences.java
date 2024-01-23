/*
 * easy
 * time:O(n);space:O(n)
 */

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();// HashSet<Integer> unique_val = new HashSet(map.values());
        for (int val : map.values()) {
            set.add(val);
        }

        return set.size() == map.size();
    }
}
