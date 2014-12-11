import java.util.*;

public class nQueenII {
    int tryQueen(int k, int n, boolean[] colFlag, boolean[] leftDiagFlag, boolean[] rightDiagFlag) {
	if (k == n) {
	    return 1;
	} else {
	    int ans = 0;
	    for (int i = 0; i < n; i++) {
		if (!colFlag[i] && !leftDiagFlag[k + i] && !rightDiagFlag[k - i + n - 1]) {
		    colFlag[i] = true;
		    leftDiagFlag[k + i] = true;
		    rightDiagFlag[k - i + n - 1] = true;
		    ans += tryQueen(k + 1, n, colFlag, leftDiagFlag, rightDiagFlag);
		    colFlag[i] = false;
		    leftDiagFlag[k + i] = false;
		    rightDiagFlag[k - i + n - 1] = false;
		}
	    }
	    return ans;
	}
    }
    public int totalNQueens(int n) {
        if (n == 0) {
	    return 0;
	}
	boolean[] colFlag = new boolean[n];
	boolean[] leftDiagFlag = new boolean[2 * n - 1];
	boolean[] rightDiagFlag = new boolean[2 * n - 1];
	for (int i = 0; i < colFlag.length; i++) {
	    colFlag[i] = false;
	}
	for (int i = 0; i < leftDiagFlag.length; i++) {
	    leftDiagFlag[i] = false;
	    rightDiagFlag[i] = false;
	}
	return tryQueen(0, n, colFlag, leftDiagFlag, rightDiagFlag);
    }
    public static void main(String[] args) {
	nQueenII solution = new nQueenII();
	System.out.println(solution.totalNQueens(0));
	System.out.println(solution.totalNQueens(1));
	System.out.println(solution.totalNQueens(2));
	System.out.println(solution.totalNQueens(4));
	System.out.println(solution.totalNQueens(8));
    }
}