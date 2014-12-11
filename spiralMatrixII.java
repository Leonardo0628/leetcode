import java.util.*;

public class spiralMatrixII {
    boolean isValid(int x, int y, int n) {
	return ((x >= 0) && (x < n) && (y >= 0) && (y < n));
    }
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		matrix[i][j] = 0;
	    }
	}
	int[] dx = {0, 1, 0, -1};
	int[] dy = {1, 0, -1, 0};
	int x = 0, y = -1, d = 0;
	for (int i = 0; i < n * n; i++) {
	    while (!isValid(x + dx[d], y + dy[d], n) || (matrix[x + dx[d]][y + dy[d]] != 0)) {
		d = (d + 1) % 4;
	    }
	    x += dx[d];
	    y += dy[d];
	    matrix[x][y] = i + 1;
	}
	return matrix;
    }
    public static void main(String[] args) {
	spiralMatrixII solution = new spiralMatrixII();
	int[][] res = solution.generateMatrix(3);
	res = solution.generateMatrix(4);
	for (int i = 0; i < res.length; i++) {
	    for (int j = 0; j < res[i].length; j++) {
		System.out.print(res[i][j] + " ");
	    }
	    System.out.println();
	}
    }
}