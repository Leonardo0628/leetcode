public class sudokuSolve {
    private boolean fill(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block) {
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		if (board[i][j] == '.') {
		    int blockIdx = (i / 3) * 3 + j / 3;
		    for (int k = 0; k < 9; k++) {
			if (!row[i][k] && !col[j][k] && !block[blockIdx][k]) {
			    row[i][k] = true;
			    col[j][k] = true;
			    block[blockIdx][k] = true;
			    board[i][j] = (char)(k + '1');
			    if (fill(board, row, col, block)) {
				return true;
			    } else {
				row[i][k] = false;
				col[j][k] = false;
				block[blockIdx][k] = false;
				board[i][j] = '.';
			    }
			}
		    }
		    return false;
		}
	    }
	}
	return true;
    }
    public void solveSudoku(char[][] board) {
	boolean[][] row = new boolean[9][9];
	boolean[][] col = new boolean[9][9];
	boolean[][] block = new boolean[9][9];
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		row[i][j] = false;
		col[i][j] = false;
		block[i][j] = false;
	    }
	}
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		if (board[i][j] != '.') {
		    int blockIdx = (i / 3) * 3 + j / 3;
		    row[i][board[i][j] - '1'] = true;
		    col[j][board[i][j] - '1'] = true;
		    block[blockIdx][board[i][j] - '1'] = true;
		}
	    }
	}
	fill(board, row, col, block);
    }
    public static void main(String[] args) {
	sudokuSolve solution = new sudokuSolve();
	char[][] board = {{'5','3','.','.','7','.','.','.','.'},
			  {'6','.','.','1','9','5','.','.','.'},
			  {'.','9','8','.','.','.','.','6','.'},
			  {'8','.','.','.','6','.','.','.','3'},
			  {'4','.','.','8','.','3','.','.','1'},
			  {'7','.','.','.','2','.','.','.','6'},
			  {'.','6','.','.','.','.','2','8','.'},
			  {'.','.','.','4','1','9','.','.','5'},
			  {'.','.','.','.','8','.','.','7','9'}};
	solution.solveSudoku(board);
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		System.out.print(board[i][j] + " ");
	    }
	    System.out.println();
	}
    }
}