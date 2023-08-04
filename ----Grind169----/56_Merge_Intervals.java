class Solution {
    public int[][] merge(int[][] intervals) {
        // List<int[]> res = new ArrayList<>();
        // if (intervals.length == 0) return null;

        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // res.add(intervals[0]);

        // for (int i = 1; i < intervals.length; i++) {
        // if (intervals[i][0] <= res.get(res.size() - 1)[1]) {
        // res.get(res.size() - 1)[1] = Math.max(intervals[i][1], res.get(res.size() -
        // 1)[1]);
        // }else {
        // res.add(intervals[i]);
        // }
        // }
        // return res.toArray(new int[res.size()][]);

        // LinkedList--可用getLast(),code更简洁
        LinkedList<int[]> res = new LinkedList<>();
        if (intervals.length == 0)
            return null;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res.getLast()[1]) {
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}
