public class longestPalindrome {
    public String longestPalindrome(String s) {
	// DP: Time complexity O(n^2), Space complexity O(n^2)
	if (s.length() == 0) {
	    return "";
	}
	boolean[][] palindrome = new boolean[s.length()][s.length()];
	int maxStart = 0, maxEnd = 0;
	for (int i = 0; i < s.length(); i++) {
	    palindrome[i][i] = true;
	}
	for (int i = 0; i < s.length() - 1; i++) {
	    if (s.charAt(i) == s.charAt(i + 1)) {
		palindrome[i][i + 1] = true;
		maxStart = i;
		maxEnd = i + 1;
	    } else {
		palindrome[i][i + 1] = false;
	    }
	}
	for (int len = 3; len <= s.length(); len++) {
	    for (int i = 0; i < s.length() - len + 1; i++) {
		if (s.charAt(i) == s.charAt(i + len - 1)) {
		    palindrome[i][i + len - 1] = palindrome[i + 1][i + len - 2];
		    if (palindrome[i][i + len - 1]) {
			maxStart = i;
			maxEnd = i + len - 1;
		    }
		} else {
		    palindrome[i][i + len - 1] = false;
		}
	    }
	}
        return s.substring(maxStart, maxEnd + 1);
    }
    public static void main(String[] args) {
	longestPalindrome solution = new longestPalindrome();
	System.out.println(solution.longestPalindrome(""));
	System.out.println(solution.longestPalindrome("a"));
	System.out.println(solution.longestPalindrome("ab"));
	System.out.println(solution.longestPalindrome("aba"));
    }
}