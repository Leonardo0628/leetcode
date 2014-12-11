public class longestValidParentheses {
    // DP, Time complexity: O(n)
    public int longestValidParentheses(String s) {
	s = s + '(';
        int[] len = new int[s.length()];
	int max = 0;
	len[s.length() - 1] = 0;
	for (int i = s.length() - 2; i >=0; i--) {
	    if ((s.charAt(i) == '(') && (s.charAt(i + 1 + len[i + 1]) == ')')) {
		len[i] = len[i + 1] + 2 + len[i + len[i + 1] + 2];
		max = Math.max(max, len[i]);
	    } else {
		len[i] = 0;
	    }
	}
	return max;
    }
    public static void main(String[] args) {
	longestValidParentheses solution = new longestValidParentheses();
	System.out.println(solution.longestValidParentheses("(()"));
	System.out.println(solution.longestValidParentheses(")()())"));
    }
}