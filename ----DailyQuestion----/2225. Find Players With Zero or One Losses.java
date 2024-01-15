/*
 * medium
 * time:O(n);space:O(n)
 */

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> winner = new HashMap<>();
        HashMap<Integer, Integer> loser = new HashMap<>();

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> notLost = new ArrayList<>();
        List<Integer> oneLost = new ArrayList<>();

        int len = matches.length;

        for (int i = 0; i < len; i++) {
            winner.put(matches[i][0], winner.getOrDefault(matches[i][0], 0) + 1);
            loser.put(matches[i][1], loser.getOrDefault(matches[i][1], 0) + 1);
        }

        for (int key : winner.keySet()) {
            if (!loser.containsKey(key)) {
                notLost.add(key);
            }
        }

        for (int key : loser.keySet()) {
            if (loser.get(key) == 1) {
                oneLost.add(key);
            }
        }

        Collections.sort(notLost);
        Collections.sort(oneLost);

        res.add(notLost);
        res.add(oneLost);

        return res;
    }
}
