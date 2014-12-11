public class useMinStack {
    public static void main(String[] args) {
	MinStack stack = new MinStack();
	stack.push(2);
	stack.push(1);
	stack.push(1);
	stack.push(3);
	System.out.println(stack.top());
	System.out.println(stack.getMin());
    }
}