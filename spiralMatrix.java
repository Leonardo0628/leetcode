import java.util.*;

public class spiralMatrix {
    private boolean isValid(int x, int y, int[][] matrix) {
	return ((x >= 0) && (x < matrix.length) && (y >= 0) && (y < matrix[0].length));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new LinkedList<Integer>();
	if (matrix.length == 0) {
	    return order;
	}
	boolean[][] visit = new boolean[matrix.length][matrix[0].length];
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[i].length; j++) {
		visit[i][j] = false;
	    }
	}
	int[] dx = {0, 1, 0, -1};
	int[] dy = {1, 0, -1, 0};
	int x = 0, y = -1, d = 0;
	for (int i = 0; i < matrix.length * matrix[0].length; i++) {
	    while (!isValid(x + dx[d], y + dy[d], matrix) || visit[x + dx[d]][y + dy[d]]) {
		d = (d + 1) % 4;
	    }
	    x += dx[d];
	    y += dy[d];
	    visit[x][y] = true;
	    order.add(matrix[x][y]);
	}
	return order;
    }
    public static void main(String[] args) {
	spiralMatrix solution = new spiralMatrix();
	int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	System.out.println(solution.spiralOrder(matrix));
    }
}