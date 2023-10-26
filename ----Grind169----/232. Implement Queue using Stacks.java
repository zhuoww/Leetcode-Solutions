class MyQueue {
    Stack<Integer> stIn;
    Stack<Integer> stOut;

    public MyQueue() {
        stIn = new Stack<>();
        stOut = new Stack<>();
    }

    public void push(int x) {
        stIn.push(x);
    }

    public int pop() {
        peek();
        return stOut.pop();
    }

    public int peek() {
        if (stOut.isEmpty()) {
            while (!stIn.isEmpty()) {
                stOut.push(stIn.pop());
            }
        }
        return stOut.peek();
    }

    public boolean empty() {
        return stIn.isEmpty() && stOut.isEmpty();

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
