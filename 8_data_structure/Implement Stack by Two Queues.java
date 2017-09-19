class Stack {
    
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    
    public void push(int x) {
        q2.offer(x);
    }

    // Pop the top of the stack
    public void pop() {
        top();
        q2.poll();
    }

    // Return the top of the stack
    public int top() {
        if (q2.size() == 0) {
            Queue<Integer> temp = q2;
            q2 = q1;
            q1 = temp;
        }
        int size = q2.size();
        for (int i = 0; i < size - 1; i++) {
            q1.offer(q2.poll());
        }
        return q2.peek();
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        return q1.size() + q2.size() == 0;
    }    
}
