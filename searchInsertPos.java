public class searchInsertPos {
    public int searchInsert(int[] A, int target) {
        int start = 0, end = A.length - 1;
	while (start <= end) {
	    int mid = (start + end) / 2;
	    if (A[mid] == target) {
		return mid;
	    }
	    if (A[mid] > target) {
		end = mid - 1;
	    } else {
		start = mid + 1;
	    }
	}
	return start;
    }
    public static void main(String[] args) {
	searchInsertPos solution = new searchInsertPos();
	int[] list = {};
	//int[] list = {1, 3, 5, 6};
	System.out.println(solution.searchInsert(list, 5));
	System.out.println(solution.searchInsert(list, 2));
	System.out.println(solution.searchInsert(list, 7));
	System.out.println(solution.searchInsert(list, 0));
    }
}