//850 lintcode
/**
 * Definition of Interval:
 * public class Interval {
 * int start, end;
 * Interval(int start, int end) {
 * this.start = start;
 * this.end = end;
 * }
 * }
 */

public class Solution {
    /**
     * @param schedule: a list schedule of employees
     * @return: Return a list of finite intervals
     */
    public List<Interval> employeeFreeTime(int[][] schedule) {
        // Write your code here
        List<Interval> temp = new ArrayList<>();
        for (int[] s : schedule) {
            for (int i = 0; i + 1 < s.length; i += 2) {
                temp.add(new Interval(s[i], s[i + 1]));
            }
        }

        Collections.sort(temp, (a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });

        List<Interval> res = new ArrayList<>();
        Interval pre = temp.get(0);
        for (int i = 1; i < temp.size(); i++) {
            Interval cur = temp.get(i);
            if (cur.start > pre.end) {
                res.add(new Interval(pre.end, cur.start));
                pre = cur;
            } else {
                pre.end = Math.max(cur.end, pre.end);
            }

        }
        return res;
    }
}
