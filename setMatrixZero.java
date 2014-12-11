public class setMatrixZero {
    public void setZeroes(int[][] matrix) {
	if (matrix.length == 0) {
	    return;
	}
        boolean firstRow = false, firstCol = false;
	for (int j = 0; j < matrix[0].length; j++) {
	    if (matrix[0][j] == 0) {
		firstRow = true;
		break;
	    }
	}
	for (int i = 0; i < matrix.length; i++) {
	    if (matrix[i][0] == 0) {
		firstCol = true;
		break;
	    }
	}
	for (int i = 1; i < matrix.length; i++) {
	    for (int j = 1; j < matrix[0].length; j++) {
		if (matrix[i][j] == 0) {
		    matrix[i][0] = 0;
		    matrix[0][j] = 0;
		}
	    }
	}
	for (int i = 1; i < matrix.length; i++) {
	    for (int j = 1; j < matrix[i].length; j++) {
		if ((matrix[i][0] == 0) || (matrix[0][j] == 0)) {
		    matrix[i][j] = 0;
		}
	    }
	}
	if (firstRow) {
	    for (int j = 0; j < matrix[0].length; j++) {
		matrix[0][j] = 0;
	    }
	}
	if (firstCol) {
	    for (int i = 0; i < matrix.length; i++) {
		matrix[i][0] = 0;
	    }
	}
    }
    public static void main(String[] args) {
	setMatrixZero solution = new setMatrixZero();
	int[][] matrix = {{0, 2, 3, 4},
			  {5, 0, 7, 8},
			  {9, 10, 11, 12},
			  {13, 14, 15, 16},
			  {17, 18, 19, 20}};
	solution.setZeroes(matrix);
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[0].length; j++) {
		System.out.print(matrix[i][j] + "\t");
	    }
	    System.out.println();
	}
    }
}