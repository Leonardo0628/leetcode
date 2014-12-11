public class reMatch {
    boolean match(String s, int sIndex, String p, int pIndex) {
	if (pIndex >= p.length()) {
	    if (sIndex >= s.length()) {
		return true;
	    }
	    return false;
	}
	if ((pIndex == p.length() - 1) || (p.charAt(pIndex + 1) != '*')) {
	    if (sIndex >= s.length()) {
		return false;
	    }
	    boolean currMatch = ((p.charAt(pIndex) == '.') || (p.charAt(pIndex) == s.charAt(sIndex)));
	    if (currMatch) {
		return match(s, sIndex + 1, p, pIndex + 1);
	    }
	} else {
	    if (p.charAt(pIndex) == '.') {
		for (int i = sIndex; i <= s.length(); i++) {
		    if (match(s, i, p, pIndex + 2)) {
			return true;
		    }
		}
	    } else {
		if (match(s, sIndex, p, pIndex + 2)) {
		    return true;
		}
		int i = sIndex;
		while ((i < s.length()) && (s.charAt(i) == p.charAt(pIndex))) {
		    if (match(s, i + 1, p, pIndex + 2)) {
			return true;
		    }
		    i++;
		}
	    }
	}
	return false;
    }
    public boolean isMatch(String s, String p) {
        return match(s, 0, p, 0);
    }
    public static void main(String[] args) {
	reMatch solution = new reMatch();
	System.out.println(solution.isMatch("aa", "a"));
	System.out.println(solution.isMatch("aa", "aa"));
	System.out.println(solution.isMatch("aaa", "aa"));
	System.out.println(solution.isMatch("aa", "a*"));
	System.out.println(solution.isMatch("aa", ".*"));
	System.out.println(solution.isMatch("ab", ".*"));
	System.out.println(solution.isMatch("aab", "c*a*b*"));
    }
}