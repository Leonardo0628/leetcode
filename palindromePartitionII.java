public class palindromePartitionII {
    public int minCut(String s) {
	if (s.length() == 0) {
	    return 0;
	}
	boolean[][] palindrome = new boolean[s.length()][s.length()];
	for (int i = 0; i < s.length(); i++) {
	    palindrome[i][i] = true;
	}
	for (int i = 0; i < s.length() - 1; i++) {
	    palindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
	}
	for (int len = 3; len <= s.length(); len++) {
	    for (int i = 0; i < s.length() - len + 1; i++) {
		if (s.charAt(i) == s.charAt(i + len - 1)) {
		    palindrome[i][i + len - 1] = palindrome[i + 1][i + len - 2];
		} else {
		    palindrome[i][i + len - 1] = false;
		}
	    }
	}
	int[] min = new int[s.length()];
	min[0] = 0;
	for (int i = 1; i < s.length(); i++) {
	    if (palindrome[0][i]) {
		min[i] = 0;
	    } else {
		min[i] = s.length();
		for (int j = 0; j < i; j++) {
		    if (palindrome[j + 1][i]) {
			min[i] = Math.min(min[i], min[j] + 1);
		    }
		}
	    }
	}
	return min[s.length() - 1];
    }
    public static void main(String[] args) {
	palindromePartitionII solution = new palindromePartitionII();
	System.out.println(solution.minCut("aab"));
	System.out.println(solution.minCut(""));
	System.out.println(solution.minCut("a"));
	System.out.println(solution.minCut("aabaa"));
	System.out.println(solution.minCut("aabbcc"));
    }
}