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
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if (intervals.size() == 0)
            return 0;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);

        for (Interval interval : intervals) {
            if (!pq.isEmpty() && interval.start >= pq.peek().end) {
                pq.poll();
            }
            pq.offer(interval);
        }
        return pq.size();
    }
}
