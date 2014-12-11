public class uniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
	f[0][0] = 1 - obstacleGrid[0][0];
	for (int i = 1; i < m; i++) {
	    if (obstacleGrid[i][0] == 1) {
		f[i][0] = 0;
	    } else {
		f[i][0] = f[i - 1][0];
	    }
	}
	for (int j = 1; j < n; j++) {
	    if (obstacleGrid[0][j] == 1) {
		f[0][j] = 0;
	    } else {
		f[0][j] = f[0][j - 1];
	    }
	}
	for (int i = 1; i < m; i++) {
	    for (int j = 1; j < n; j++) {
		if (obstacleGrid[i][j] == 1) {
		    f[i][j] = 0;
		} else {
		    f[i][j] = f[i - 1][j] + f[i][j - 1];
		}
	    }
	}
	return f[m - 1][n - 1];
    }
    public static void main(String[] args) {
	uniquePathII solution = new uniquePathII();
	int[][] grid = {{0, 0, 0},
			{0, 1, 0},
			{0, 0, 0}};
	System.out.println(solution.uniquePathsWithObstacles(grid));
    }
}