public class findMinInRotateSortArrayII {
    public int findMin(int[] num) {
        int start = 0, end = num.length - 1;
	int mid;
	while (start < end) {
	    if (num[start] < num[end]) {
		return num[start];
	    }
	    mid = (start + end) / 2;
	    if (num[mid] > num[start]) {
		start = mid + 1;
	    } else if (num[mid] < num[start]) {
		end = mid;
	    } else {
		start++;
	    }
	}
	return num[start];
    }
    public static void main(String[] args) {
	findMinInRotateSortArrayII solution = new findMinInRotateSortArrayII();
	int[] num = {4, 5, 6, 7, 0, 1, 2};
	System.out.println(solution.findMin(num));
    }
}