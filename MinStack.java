import java.util.*;

class MinStack {

    Stack<Long> stack;
    int min;

    public MinStack() {
	stack = new Stack<Long>();
    }

    public void push(int x) {
        if (stack.size() == 0) {
	    stack.push((long)0);
	    min = x;
	} else {
	    stack.push((long)x - (long)min);
	    min = Math.min(min, x);
	}
    }

    public void pop() {
	long top = stack.pop();
        if (top < 0) {
	    min -= top;
	}
    }

    public int top() {
	long top = stack.peek();
	if (top >= 0) {
	    return (int)(top + min);
	} else {
	    return min;
	}
    }

    public int getMin() {
        return min;
    }
}