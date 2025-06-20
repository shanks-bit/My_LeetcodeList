// leetcode -> class MinStack {
    Stack<Integer> normStack;
    Stack<Integer> minStack;
    public MinStack() {
        normStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        normStack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (normStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        normStack.pop();
    }
    
    public int top() {
        return normStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */ 
