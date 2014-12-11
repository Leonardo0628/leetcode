public class searchForARange {
    // Find the smallest index i such that target <= A[i] <= A[i + 1] <= ...
    int leftSearch(int[] A, int target) {
	int start = 0, end = A.length - 1;
	while (start <= end) {
	    int mid = (start + end) / 2;
	    if (A[mid] >= target) {
		if ((mid >= 1) && (A[mid - 1] >= target)) {
		    end = mid - 1;
		} else {
		    return mid;
		}
	    } else {
		start = mid + 1;
	    }
	}
	return start;
    }
    public int[] searchRange(int[] A, int target) {
	int leftIdx = leftSearch(A, target), rightIdx = leftSearch(A, target + 1) - 1;
	if (leftIdx <= rightIdx) {
	    int[] idx = {leftIdx, rightIdx};
	    return idx;
	} else {
	    int[] idx = {-1, -1};
	    return idx;
	}
    }
    public static void main(String[] args) {
	searchForARange solution = new searchForARange();
	int[] list = {3, 5, 5, 5, 7};
	System.out.println(solution.searchRange(list, 5)[0]);
	System.out.println(solution.searchRange(list, 5)[1]);
    }
}