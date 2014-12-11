public class mergeSortArray {
    public void merge(int A[], int m, int B[], int n) {
        int pA = m - 1, pB = n - 1;
	while ((pA >= 0) && (pB >= 0)) {
	    if (A[pA] < B[pB]) {
		A[pA + pB + 1] = B[pB];
		pB--;
	    } else {
		A[pA + pB + 1] = A[pA];
		pA--;
	    }
	}
	while (pB >= 0) {
	    A[pB] = B[pB];
	    pB--;
	}
    }
    public static void main(String[] args) {
	mergeSortArray solution = new mergeSortArray();
	int[] A = {1, 3, 5, 7, 0, 0, 0};
	int[] B = {2, 4, 6};
	int m = 4, n = 3;
	solution.merge(A, m, B, n);
	for (int i = 0; i < m + n; i++) {
	    System.out.print(A[i] + " ");
	}
	System.out.println();
    }
}