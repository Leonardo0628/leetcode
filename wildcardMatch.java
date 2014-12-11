public class wildcardMatch {
    public boolean isMatch(String s, String p) {
	// starP marks the position of the star in p
	// The star matches chars before starS
	int p1 = 0, p2 = 0, starS = 0, starP = -1;
	while (p1 < s.length()) {
	    if (p2 < p.length()) {
		if (p.charAt(p2) != '*') {
		    if ((p.charAt(p2) == '?') || (s.charAt(p1) == p.charAt(p2))) {
			p1++;
			p2++;
			continue;
		    }
		} else {
		    // The star matches nothing at the begining
		    starS = p1;
		    starP = p2++;
		    continue;
		}
	    }
	    // Match fails, the star matches one additional char
	    if (starP != -1) {
		p1 = ++starS;
		p2 = starP + 1;
	    } else {
		return false;
	    }
	}
	while (p2 < p.length()) {
	    if (p.charAt(p2) != '*') {
		return false;
	    }
	    p2++;
	}
	return true;
    }
    public static void main(String[] args) {
	wildcardMatch solution = new wildcardMatch();
	System.out.println(solution.isMatch("aa", "a"));
	System.out.println(solution.isMatch("aa", "aa"));
	System.out.println(solution.isMatch("aaa", "aa"));
	System.out.println(solution.isMatch("aa", "*"));
	System.out.println(solution.isMatch("aa", "a*"));
	System.out.println(solution.isMatch("ab", "?*"));
	System.out.println(solution.isMatch("aab", "c*a*b"));
    }
}