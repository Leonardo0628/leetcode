public class removeDuplicateFromSortArrayII {
    public int removeDuplicates(int[] A) {
	if (A.length == 0) {
	    return 0;
	}
	// Two pointers
	int p1 = 0, p2 = 1;
	while (p2 < A.length) {
	    if (A[p2] == A[p2 - 1]) {
		p1++;
		A[p1] = A[p2];
		p2++;
	    }
	    while ((p2 < A.length) && (A[p2] == A[p2 - 1])) {
		p2++;
	    }
	    if (p2 < A.length) {
		p1++;
		A[p1] = A[p2];
		p2++;
	    }
	}
	return (p1 + 1);
    }
    public static void main(String[] args) {
	removeDuplicateFromSortArrayII solution = new removeDuplicateFromSortArrayII();
	int[] num = {1, 1, 1, 2, 2, 3};
	int newLen = solution.removeDuplicates(num);
	for (int i = 0; i < newLen; i++) {
	    System.out.print(num[i] + " ");
	}
	System.out.println();
    }
}