import java.util.*;

public class validParentheses {
    public boolean isValid(String s) {
	Deque<Character> stack = new LinkedList<Character>();
	for (int i = 0; i < s.length(); i++) {
	    switch (s.charAt(i)) {
	    case '(': ;
	    case '[': ;
	    case '{': stack.push(s.charAt(i)); break;
	    case ')': if ((stack.size() == 0) || (stack.pop() != '(')) {
		return false;
	    }
		break;
	    case ']': if ((stack.size() == 0) || (stack.pop() != '[')) {
		    return false;
		}
		break;
	    case '}': if ((stack.size() == 0) || (stack.pop() != '{')) {
		    return false;
		}
		break;
	    }
	}
        return (stack.size() == 0);
    }
    public static void main(String[] args) {
	validParentheses solution = new validParentheses();
	System.out.println(solution.isValid("()"));
	System.out.println(solution.isValid("()[]{}"));
	System.out.println(solution.isValid("(]"));
	System.out.println(solution.isValid("([)]"));
	System.out.println(solution.isValid(""));
	System.out.println(solution.isValid("("));
	System.out.println(solution.isValid(")"));
    }
}