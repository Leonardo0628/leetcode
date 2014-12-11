public class maximumProductSubarray {
    public int maxProduct(int[] A) {
        int[] max = new int[A.length], min = new int[A.length];
	int maxProd = A[0];
	max[0] = A[0];
	min[0] = A[0];
	for (int i = 1; i < A.length; i++) {
	    max[i] = Math.max(A[i], Math.max(max[i - 1] * A[i], min[i - 1] * A[i]));
	    min[i] = Math.min(A[i], Math.min(max[i - 1] * A[i], min[i - 1] * A[i]));
	    maxProd = Math.max(maxProd, max[i]);
	}
	return maxProd;
    }
    public static void main(String[] args) {
	maximumProductSubarray solution = new maximumProductSubarray();
	int[] num = {-2, 4};
	System.out.println(solution.maxProduct(num));
    }
}