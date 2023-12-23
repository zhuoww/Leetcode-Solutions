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

class Solution {
    public boolean isPathCrossing(String path) {
        HashMap<Character, Pair<Integer, Integer>> map = new HashMap<>();
        map.put('N', new Pair(0, 1));
        map.put('S', new Pair(0, -1));
        map.put('E', new Pair(1, 0));
        map.put('W', new Pair(-1, 0));

        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        set.add(new Pair(0, 0));
        int x = 0;
        int y = 0;

        for (Character c : path.toCharArray()) {
            Pair<Integer, Integer> cur = map.get(c);
            int dx = cur.getKey();
            int dy = cur.getValue();
            x += dx;
            y += dy;

            Pair p = new Pair(x, y);
            if (set.contains(p))
                return true;
            set.add(p);
        }
        return false;
    }
}