public class interleaveStr {
    public boolean isInterleave(String s1, String s2, String s3) {
	if (s1.length() + s2.length() != s3.length()) {
	    return false;
	}
	boolean[][] interleave = new boolean[s1.length() + 1][s2.length() + 1];
	interleave[0][0] = true;
	for (int i = 1; i <= s1.length(); i++) {
	    interleave[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && interleave[i - 1][0];
	}
	for (int i = 1; i <= s2.length(); i++) {
	    interleave[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1)) && interleave[0][i - 1];
	}
	for (int i = 1; i <= s1.length(); i++) {
	    for (int j = 1; j <= s2.length(); j++) {
		interleave[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1)) && interleave[i - 1][j];
		interleave[i][j] |= (s2.charAt(j - 1) == s3.charAt(i + j - 1)) && interleave[i][j - 1];
	    }
	}
	return interleave[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
	interleaveStr solution = new interleaveStr();
	System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}