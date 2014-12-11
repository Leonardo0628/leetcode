public class sortColor {
    public void sortColors(int[] A) {
	int start = 0, end = A.length - 1, i = 0;
	while (i < A.length) {
	    if (A[i] == 0) {
		if (i > start) {
		    A[i] = A[start];
		    A[start] = 0;
		    start++;
		    i--;
		}
	    } else if (A[i] == 2) {
		if (i < end) {
		    A[i] = A[end];
		    A[end] = 2;
		    end--;
		    i--;
		}
	    }
	    i++;
	}
    }
    public static void main(String[] args) {
	sortColor solution = new sortColor();
	int[] col = {2, 1, 0};
	solution.sortColors(col);
	for (int i = 0; i < col.length; i++) {
	    System.out.print(col[i] + " ");
	}
	System.out.println();
    }
}