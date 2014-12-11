public class wordSearch {
    private boolean isValid(char[][] board, int x, int y) {
	return ((x >= 0) && (x < board.length) && (y >= 0) && (y < board[0].length));
    }
    private boolean search(char[][] board, String word, int x, int y, boolean[][] visit) {
	if (word.length() == 0) {
	    return true;
	}
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};
	for (int d = 0; d < 4; d++) {
	    int newX = x + dx[d], newY = y + dy[d];
	    if (isValid(board, newX, newY) && (!visit[newX][newY]) && (board[newX][newY] == word.charAt(0))) {
		visit[newX][newY] = true;
		if (search(board, word.substring(1), newX, newY, visit)) {
		    return true;
		}
		visit[newX][newY] = false;
	    }
	}
	return false;
    }
    public boolean exist(char[][] board, String word) {
	if (word.length() == 0) {
	    return true;
	}
	boolean[][] visit = new boolean[board.length][board[0].length];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[0].length; j++) {
		visit[i][j] = false;
	    }
	}
        for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[0].length; j++) {
		if (board[i][j] == word.charAt(0)) {
		    visit[i][j] = true; 
		    if (search(board, word.substring(1), i, j, visit)) {
			return true;
		    }
		    visit[i][j] = false;
		}
	    }
	}
	return false;
    }
    public static void main(String[] args) {
	wordSearch solution = new wordSearch();
	char[][] board = {{'A', 'B', 'C', 'E'},
			  {'S', 'F', 'C', 'S'},
			  {'A', 'D', 'E', 'E'}};
	System.out.println(solution.exist(board, "ABCCED"));
	System.out.println(solution.exist(board, "SEE"));
	System.out.println(solution.exist(board, "ABCB"));
	System.out.println(solution.exist(board, ""));
	System.out.println(solution.exist(board, "G"));
    }
}