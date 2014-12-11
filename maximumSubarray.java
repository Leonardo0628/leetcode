public class maximumSubarray {
    public int maxSubArray(int[] A) {
	int maxSum = A[0];
	for (int i = 1; i < A.length; i++) {
	    maxSum = Math.max(maxSum, A[i]);
	}
	if (maxSum < 0) {
	    return maxSum;
	}
        int[] f = new int[A.length];
	f[0] = Math.max(0, A[0]);
	for (int i = 1; i < A.length; i++) {
	    f[i] = Math.max(0, f[i - 1] + A[i]);
	    maxSum = Math.max(maxSum, f[i]);
	}
	return maxSum;
    }
    public static void main(String[] args) {
	maximumSubarray solution = new maximumSubarray();
	//int[] list = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
	int[] list = {-2, -3, -1, -5};
	System.out.println(solution.maxSubArray(list));
    }
}