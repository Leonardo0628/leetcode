import java.util.*;

public class surroundRegion {
    private boolean isValid(char[][] board, int i, int j) {
	return ((i >= 0) && (i < board.length) && (j >= 0) && (j < board[0].length));
    }
    private void travel(char[][] board, int i, int j) {
	if (board[i][j] != 'O') {
	    return;
	}
	board[i][j] = '+';
	Queue<Integer> row = new LinkedList<Integer>();
	Queue<Integer> col = new LinkedList<Integer>();
	int[] dx = {1, -1, 0, 0};
	int[] dy = {0, 0, 1, -1};
	row.offer(i);
	col.offer(j);
	while (row.size() > 0) {
	    int x = row.poll();
	    int y = col.poll();
	    for (int d = 0; d < 4; d++) {
		int newX = x + dx[d];
		int newY = y + dy[d];
		if (isValid(board, newX, newY) && (board[newX][newY] == 'O')) {
		    board[newX][newY] = '+';
		    row.offer(newX);
		    col.offer(newY);
		}
	    }
	}
    }
    public void solve(char[][] board) {
	for (int i = 0; i < board.length; i++) {
	    if (board[i].length > 0) {
		travel(board, i, 0);
		travel(board, i, board[i].length - 1);
	    }
	}
	if (board.length > 0) {
	    for (int j = 0; j < board[0].length; j++) {
		travel(board, 0, j);
		travel(board, board.length - 1, j);
	    }
	}
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j] == '+') {
		    board[i][j] = 'O';
		} else {
		    board[i][j] = 'X';
		}
	    }
	}
    }
    public static void main(String[] args) {
	surroundRegion solution = new surroundRegion();
	char[][] board = {{'X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
			  {'O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','X','X'},
			  {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','X'}};
	solution.solve(board);
	for (int i = 0; i <= board.length - 1; i++) {
	    for (int j = 0; j <= board[i].length - 1; j++) {
		System.out.print(board[i][j]);
	    }
	    System.out.println();
	}
    }
}