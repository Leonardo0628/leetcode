public class firstMissPos {
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++) {
	    while ((A[i] > 0) && (A[i] <= A.length) && (A[i] != i + 1) && (A[i] != A[A[i] - 1])) {
		int tmp = A[i];
		A[i] = A[tmp - 1];
		A[tmp - 1] = tmp;
	    }
	}
	for (int i = 0; i < A.length; i++) {
	  if (A[i] != i + 1) {
	    return (i + 1);
	  }
	}
	return (A.length + 1);
    }
    public static void main(String[] args) {
	firstMissPos solution = new firstMissPos();
	//int[] num = {3, 4, -1, 1};
	int[] num = {1, 1};
	System.out.println(solution.firstMissingPositive(num));
    }
}