/*
 * easy
 * time:O(n);space:O(n)
 */

class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<Pair> set = new HashSet<>();
        int x = 0;
        int y = 0;
        set.add(new Pair(x, y));
        for (Character c : path.toCharArray()) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }
            Pair p = new Pair(x, y);
            if (set.contains(p))
                return true;
            set.add(p);
        }
        return false;
    }
}
