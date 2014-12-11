public class validSudoku {
    public boolean isValidSudoku(char[][] board) {
	if ((board.length != 9) || (board[0].length != 9)) {
	    return false;
	}
	boolean[][] row = new boolean[9][9], col = new boolean[9][9], block = new boolean[9][9];
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		row[i][j] = false;
		col[i][j] = false;
		block[i][j] = false;
	    }
	}
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		if ((board[i][j] >= '0') && (board[i][j] <= '9')) {
		    int num = board[i][j] - '0';
		    int blockIdx = (i / 3) * 3 + j / 3;
		    if (row[i][num - 1] || col[j][num - 1] || block[blockIdx][num - 1]) {
			return false;
		    } else {
			row[i][num - 1] = true;
			col[j][num - 1] = true;
			block[blockIdx][num - 1] = true;
		    }
		} else if (board[i][j] != '.') {
		    return false;
		}
	    }
	}
	return true;
    }
    public static void main(String[] args) {
	validSudoku solution = new validSudoku();
	char[][] board = {{'5','3','.','.','7','.','.','.','.'},
			  {'6','.','.','1','9','5','.','.','.'},
			  {'.','9','8','.','.','.','.','6','.'},
			  {'8','.','.','.','6','.','.','.','3'},
			  {'4','.','.','8','.','3','.','.','1'},
			  {'7','.','.','.','2','.','.','.','6'},
			  {'.','6','.','.','.','.','2','8','.'},
			  {'.','.','.','4','1','9','.','.','5'},
			  {'.','.','.','.','8','.','.','7','9'}};
	System.out.println(solution.isValidSudoku(board));
    }
}