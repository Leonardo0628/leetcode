import java.util.*;

public class evaluateReversePolish {
    public int evalRPN(String[] tokens) {
	Set<String> operators = new HashSet<String>(Arrays.asList("+","-","*","/"));
	Deque<Integer> stack = new LinkedList<Integer>();
	for (String s : tokens) {
	    if (operators.contains(s)) {
		int number1 = stack.pop();
		int number2 = stack.pop();
		switch (s.charAt(0)) {
		case '+': stack.push(number2 + number1); break;
		case '-': stack.push(number2 - number1); break;
		case '*': stack.push(number2 * number1); break;
		case '/': stack.push(number2 / number1);
		}
	    } else {
		stack.push(new Integer(s));
	    }
	}
	return stack.pop();
    }
    public static void main(String[] args) {
	evaluateReversePolish solution = new evaluateReversePolish();
	String[] rpn1 = {"2","1","+","3","*"};
	String[] rpn2 = {"4","13","5","/","+"};
	System.out.println(solution.evalRPN(rpn1));
	System.out.println(solution.evalRPN(rpn2));
    }
}