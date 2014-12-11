public class searchInRotateSortArray {
    public int search(int[] A, int target) {
        int start = 0, end = A.length - 1;
	int mid;
	while (start <= end) {
	    mid = (start + end + 1) / 2;
	    if (A[mid] == target) {
		return mid;
	    }
	    if (A[mid] > A[start]) {
		if ((target < A[mid]) && (target >= A[start])) {
		    end = mid - 1;
		} else {
		    start = mid + 1;
		}
	    } else if ((target > A[mid]) && (target < A[start])) {
		start = mid + 1;
	    } else {
		end = mid - 1;
	    }
	}
	return -1;
    }
    public static void main(String[] args) {
	searchInRotateSortArray solution = new searchInRotateSortArray();
	int[] num = {4, 5, 6, 7, 0, 1, 2};
	System.out.println(solution.search(num, 5));
	System.out.println(solution.search(num, 4));
	System.out.println(solution.search(num, 2));
	System.out.println(solution.search(num, 8));
	System.out.println(solution.search(num, -3));
	System.out.println(solution.search(num, 1));
	System.out.println(solution.search(num, 6));
    }
}