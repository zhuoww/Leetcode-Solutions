import java.util.Stack;

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
