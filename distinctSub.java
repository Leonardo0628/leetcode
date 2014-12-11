public class distinctSub {
    public int numDistinct(String S, String T) {
	int[][] num = new int[S.length() + 1][T.length() + 1];
	for (int i = 0; i <= S.length(); i++) {
	    num[i][0] = 1;
	}
	for (int i = 1; i <= T.length(); i++) {
	    num[0][i] = 0;
	}
	for (int i = 1; i <= S.length(); i++) {
	    for (int j = 1; j <= T.length(); j++) {
		num[i][j] = num[i - 1][j];
		if (S.charAt(i - 1) == T.charAt(j - 1)) {
		    num[i][j] += num[i - 1][j - 1];
		}
	    }
	}
	return num[S.length()][T.length()];
    }
    public static void main(String[] args) {
	distinctSub solution = new distinctSub();
	System.out.println(solution.numDistinct("rabbbit", "rabbit"));
	System.out.println(solution.numDistinct("rabbbbit", "rabbit"));
    }
}