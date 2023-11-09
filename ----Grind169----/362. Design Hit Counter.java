public class HitCounter {
    Queue<Integer> que;

    public HitCounter() {
        que = new LinkedList<>();
    }

    /**
     * @param timestamp: the timestamp
     * @return: nothing
     */
    public void hit(int timestamp) {
        que.offer(timestamp);
    }

    /**
     * @param timestamp: the timestamp
     * @return: the count of hits in recent 300 seconds
     */
    public int getHits(int timestamp) {
        while (!que.isEmpty() && que.peek() + 300 <= timestamp) {
            que.poll();
        }
        return que.size();
    }
}