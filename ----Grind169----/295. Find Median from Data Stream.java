class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        large = new PriorityQueue<>((a, b) -> a - b);// minHeap
        small = new PriorityQueue<>((a, b) -> b - a);// maxHeap
    }

    public void addNum(int num) {
        small.add(num);
        if (small.size() - large.size() > 1 || !large.isEmpty() && large.peek() < small.peek()) {
            large.add(small.poll());
        }
        if (large.size() - small.size() > 1) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) {
            return (double) (small.peek() + large.peek()) / 2;
        } else if (small.size() > large.size()) {
            return (double) small.peek();
        } else {
            return (double) large.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
