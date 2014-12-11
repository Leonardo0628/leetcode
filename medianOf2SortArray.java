public class medianOf2SortArray {
    // Find the top kth element in A+B
    private int findKth(int A[], int Astart, int B[], int Bstart, int k) {
	// Guarantee that A is shorter than B
	if (A.length - Astart > B.length - Bstart) {
	    return findKth(B, Bstart, A, Astart, k);
	}
	// A is empty
	if (Astart >= A.length) {
	    return B[Bstart + k - 1];
	}
	if (k == 1) {
	    return Math.min(A[Astart], B[Bstart]);
	}
	int Amid = Math.min(Astart + k / 2 - 1, A.length - 1);
	int Bmid = Bstart + k - (Amid - Astart) - 2;
	// B[Bstart..Bmid] can't be the top kth element, we threw (Bmid - Bstart + 1) elements
	if (A[Amid] > B[Bmid]) {
	    return findKth(A, Astart, B, Bmid + 1, k - (Bmid - Bstart) - 1);
	} else if (A[Amid] < B[Bmid]) {
	    // A[Astart..Amid] can't be the top kth element, we threw (Amid - Astart + 1) elements
	    return findKth(A, Amid + 1, B, Bstart, k - (Amid - Astart) - 1);
	} else {
	    return A[Amid];
	}
    }
    public double findMedianSortedArrays(int A[], int B[]) {
	// If the length is an odd num, simply return the midpoint num
	if ((A.length + B.length) % 2 != 0) {
            return (double)findKth(A, 0, B, 0, (A.length + B.length) / 2 + 1);
	} else {
	    // If the length is an even num, find the two nums in middle and take the average
	    int num1 = findKth(A, 0, B, 0, (A.length + B.length) / 2);
	    int num2 = findKth(A, 0, B, 0, (A.length + B.length) / 2 + 1);
	    return ((num1 + num2) * 1.0 / 2);
	}
    }
    public static void main(String[] args) {
	medianOf2SortArray solution = new medianOf2SortArray();
	int[] A = {1, 2}, B = {3, 4};
	System.out.println(solution.findMedianSortedArrays(A, B));
    }
}