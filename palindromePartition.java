import java.util.*;

public class palindromePartition {
    void partitioning(String s, boolean[][] palindrome, List<List<String>> list, List<String> curr, int start) {
	if (start == s.length()) {
	    List<String> copy = new LinkedList<String>();
	    copy.addAll(curr);
	    list.add(copy);
	    return;
	}
	for (int i = start; i < s.length(); i++) {
	    if (palindrome[start][i]) {
		curr.add(s.substring(start, i + 1));
		partitioning(s, palindrome, list, curr, i + 1);
		curr.remove(curr.size() - 1);
	    }
	}
    }
    public List<List<String>> partition(String s) {
        boolean[][] palindrome = new boolean[s.length()][s.length()];
	List<List<String>> list = new LinkedList<List<String>>();
	List<String> curr = new LinkedList<String>();
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
	partitioning(s, palindrome, list, curr, 0);
	return list;
    }
    public static void main(String[] args) {
	palindromePartition solution = new palindromePartition();
	System.out.println(solution.partition("aab"));
	System.out.println(solution.partition(""));
	System.out.println(solution.partition("a"));
	System.out.println(solution.partition("abba"));
    }
}