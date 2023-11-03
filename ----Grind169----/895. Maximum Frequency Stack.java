class FreqStack {
    HashMap<Integer, Integer> freqMap;
    HashMap<Integer, Stack<Integer>> freqStack;
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        freqStack = new HashMap<>();
        maxFreq = 0;
    }

    // increment value in freqMap;
    // updating the maxFreq;
    // adding value in freqStack;
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);
        if (freq > maxFreq) {
            maxFreq = freq;
        }
        freqStack.computeIfAbsent(freq, f -> new Stack()).push(val);
    }

    // return and remove the top of maxFreq;
    // decrementing maxFreq, if applicable;
    // updating freqMap;
    public int pop() {
        Stack<Integer> s = freqStack.get(maxFreq);
        int top = s.pop();
        if (s.isEmpty()) {
            maxFreq--;
        }
        freqMap.put(top, freqMap.get(top) - 1);
        return top;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
