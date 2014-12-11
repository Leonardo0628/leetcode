public class search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
	if ((matrix.length == 0) || (matrix[0].length == 0)) {
	    return false;
	}
	// Identify row
	int start = 0, end = matrix.length - 1, mid;
	while (start < end) {
	    mid = (start + end + 1) / 2;
	    if (matrix[mid][0] == target) {
		return true;
	    } else if (matrix[mid][0] > target) {
		end = mid - 1;
	    } else {
		start = mid;
	    }
	}
	int row = start;
	// Identify column
	start = 0;
	end = matrix[row].length - 1;
	while (start <= end) {
	    mid = (start + end) / 2;
	    if (matrix[row][mid] == target) {
		return true;
	    } else if (matrix[row][mid] > target) {
		end = mid - 1;
	    } else {
		start = mid + 1;
	    }
	}
	return false;
    }
    public static void main(String[] args) {
	search2DMatrix solution = new search2DMatrix();
	int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
	System.out.println(solution.searchMatrix(matrix, 1));
	System.out.println(solution.searchMatrix(matrix, 7));
	System.out.println(solution.searchMatrix(matrix, 23));
	System.out.println(solution.searchMatrix(matrix, 50));
	System.out.println(solution.searchMatrix(matrix, 0));
	System.out.println(solution.searchMatrix(matrix, 51));
	System.out.println(solution.searchMatrix(matrix, 2));
	System.out.println(solution.searchMatrix(matrix, 49));
	System.out.println(solution.searchMatrix(matrix, 10));
	System.out.println(solution.searchMatrix(matrix, 16));
	System.out.println(solution.searchMatrix(matrix, 34));
    }
}