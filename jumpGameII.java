public class jumpGameII {
    public int jump(int[] A) {
        int[] step = new int[A.length];
	int maxLen = 0;
	step[0] = 0;
	// Time complexity: O(n), since each element was visited only once
	for (int i = 0; i < A.length - 1; i++) {
	    for (int j = maxLen + 1; j <= Math.min(i + A[i], A.length - 1); j++) {
		step[j] = step[i] + 1;
	    }
	    maxLen = Math.max(maxLen, i + A[i]);
	}
	return step[A.length - 1];
    }
    public static void main(String[] args) {
	jumpGameII solution = new jumpGameII();
	int[] A = {2, 3, 1, 1, 4};
	System.out.println(solution.jump(A));
    }
}