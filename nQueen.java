import java.util.*;

public class nQueen {
    void tryQueen(int k, int n, int[] pos, boolean[] colFlag, boolean[] leftDiagFlag, boolean[] rightDiagFlag, List<String[]> ans) {
	if (k == n) {
	    String[] curr = new String[n];
	    for (int i = 0; i < n; i++) {
		curr[i] = "";
		for (int j = 0; j < n; j++) {
		    if (pos[i] == j) {
			curr[i] = curr[i] + "Q";
		    } else {
			curr[i] = curr[i] + ".";
		    }
		}
	    }
	    ans.add(curr);
	} else {
	    for (int i = 0; i < n; i++) {
		if (!colFlag[i] && !leftDiagFlag[k + i] && !rightDiagFlag[k - i + n - 1]) {
		    pos[k] = i;
		    colFlag[i] = true;
		    leftDiagFlag[k + i] = true;
		    rightDiagFlag[k - i + n - 1] = true;
		    tryQueen(k + 1, n, pos, colFlag, leftDiagFlag, rightDiagFlag, ans);
		    colFlag[i] = false;
		    leftDiagFlag[k + i] = false;
		    rightDiagFlag[k - i + n - 1] = false;
		}
	    }
	}
    }
    public List<String[]> solveNQueens(int n) {
        List<String[]> ans = new LinkedList<String[]>();
	if (n == 0) {
	    return ans;
	}
	int[] pos = new int[n];
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
	tryQueen(0, n, pos, colFlag, leftDiagFlag, rightDiagFlag, ans);
	return ans;
    }
    public static void main(String[] args) {
	nQueen solution = new nQueen();
	List<String[]> ans = solution.solveNQueens(8);
	for (int i = 0; i < ans.size(); i++) {
	    System.out.println("Solution " + (i + 1) + ":");
	    for (int j = 0; j < ans.get(i).length; j++) {
		System.out.println(ans.get(i)[j]);
	    }
	    System.out.println();
	}
    }
}