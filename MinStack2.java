import java.util.*;

class MinStack2 {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
	if (minStack.size() == 0) {
	    minStack.push(x);
	} else {
	    if (x <= stack.peek()) {
		minStack.push(x);
	    }
	}
    }

    public void pop() {
	if (minStack.peek() == stack.peek()) {
	    minStack.pop();
	}
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}