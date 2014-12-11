public class editDist {
    public int minDistance(String word1, String word2) {
        int[][] f = new int[word1.length() + 1][word2.length() + 1];
	f[0][0] = 0;
	for (int i = 1; i <= word1.length(); i++) {
	    f[i][0] = f[i - 1][0] + 1;
	}
	for (int j = 1; j <= word2.length(); j++) {
	    f[0][j] = f[0][j - 1] + 1;
	}
	for (int i = 0; i < word1.length(); i++) {
	    for (int j = 0; j < word2.length(); j++) {
		f[i + 1][j + 1] = Math.min(f[i][j + 1] + 1, f[i + 1][j] + 1);
		if (word1.charAt(i) == word2.charAt(j)) {
		    f[i + 1][j + 1] = Math.min(f[i + 1][j + 1], f[i][j]);
		} else {
		    f[i + 1][j + 1] = Math.min(f[i + 1][j + 1], f[i][j] + 1);
		}
	    }
	}
	return f[word1.length()][word2.length()];
    }
    public static void main(String[] args) {
	editDist solution = new editDist();
	System.out.println(solution.minDistance("", ""));
	System.out.println(solution.minDistance("", "abc"));
	System.out.println(solution.minDistance("abcd", ""));
	System.out.println(solution.minDistance("abde", "abc"));
    }
}