import java.util.*;

public class generateParentheses {
    void gen(int n, int left, int right, String curr, List<String> res) {
	if ((left == n) && (right == n)) {
	    res.add(curr);
	    return;
	}
	if (left < n) {
	    gen(n, left + 1, right, curr + "(", res);
	}
	if ((right < n) & (left > right)) {
	    gen(n, left, right + 1, curr + ")", res);
	}
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<String>();
	gen(n, 0, 0, "", res);
	return res;
    }
    public static void main(String[] args) {
	generateParentheses solution = new generateParentheses();
	System.out.println(solution.generateParenthesis(1));
	System.out.println(solution.generateParenthesis(2));
	System.out.println(solution.generateParenthesis(3));
    }
}