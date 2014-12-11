public class searchInRotateSortArrayII {
    public boolean search(int[] A, int target) {
        int start = 0, end = A.length - 1;
	int mid;
	while (start <= end) {
	    mid = (start + end + 1) / 2;
	    if (A[mid] == target) {
		return true;
	    }
	    if (A[mid] > A[start]) {
		if ((target < A[mid]) && (target >= A[start])) {
		    end = mid - 1;
		} else {
		    start = mid + 1;
		}
	    } else if (A[mid] < A[start]) {
		if ((target > A[mid]) && (target < A[start])) {
		    start = mid + 1;
		} else {
		    end = mid - 1;
		}
	    } else { // Worst case time complexity O(n): Don't know which part to remove
		// Consider about searching 1 in [3, 1, 3, 3, 3] or [3, 3, 3, 1, 3]
		start++;
	    }
	}
	return false;
    }
    public static void main(String[] args) {
	searchInRotateSortArrayII solution = new searchInRotateSortArrayII();
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