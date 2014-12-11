public class scrambleStr {
    public boolean isScramble(String s1, String s2) {
	if (s1.length() == 0) {
	    return true;
	}
	// scramble[i][j][k]: whether s2[j..j+k-1] is a scramble string of s1[i..i+k-1]
        boolean[][][] scramble = new boolean[s1.length()][s1.length()][s1.length()];
	// Initialize scramble
	for (int i = 0; i < s1.length(); i++) {
	    for (int j = 0; j < s2.length(); j++) {
		scramble[i][j][0] = (s1.charAt(i) == s2.charAt(j));
	    }
	}
	// DP: Time complexity O(n^4), Space complexity O(n^3)
	for (int k = 1; k < s1.length(); k++) {
	    for (int i = 0; i < s1.length() - k; i++) {
		for (int j = 0; j < s2.length() - k; j++) {
		    scramble[i][j][k] = false;
		    for (int div = 0; div < k; div++) {
			scramble[i][j][k] = (scramble[i][j][div] && scramble[i+div+1][j+div+1][k-div-1]) || (scramble[i][j+k-div][div] && scramble[i+div+1][j][k-div-1]);
			if (scramble[i][j][k]) {
			    break;
			}
		    }
		}
	    }
	}
	return scramble[0][0][s1.length() - 1];
    }
    public static void main(String[] args) {
	scrambleStr solution = new scrambleStr();
	System.out.println(solution.isScramble("great", "rgeat"));
	System.out.println(solution.isScramble("", ""));
	System.out.println(solution.isScramble("g", "r"));
	System.out.println(solution.isScramble("g", "g"));
    }
}