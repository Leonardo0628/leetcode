public class minimumPathSum {
    public int minPathSum(int[][] grid) {
	if (grid.length == 0) {
	    return 0;
	}
        int[][] f = new int[grid.length][grid[0].length];
	f[0][0] = grid[0][0];
	for (int i = 1; i < grid.length; i++) {
	    f[i][0] = f[i - 1][0] + grid[i][0];
	}
	for (int j = 1; j < grid[0].length; j++) {
	    f[0][j] = f[0][j - 1] + grid[0][j];
	}
	for (int i = 1; i < grid.length; i++) {
	    for (int j = 1; j < grid[0].length; j++) {
		f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
	    }
	}
	return f[grid.length - 1][grid[0].length - 1];
    }
    public static void main(String[] args) {
	minimumPathSum solution = new minimumPathSum();
	int[][] grid = {{1, 2, 3},
			{4, 5, 6}};
	System.out.println(solution.minPathSum(grid));
    }
}