public class removeElement {
    public int removeElement(int[] A, int elem) {
	int p1 = 0, p2 = A.length - 1;
	while (p1 < p2) {
	    if (A[p1] == elem) {
		int temp = A[p1];
		A[p1] = A[p2];
		A[p2] = temp;
		p2--;
	    } else {
		p1++;
	    }
	}
	if ((p1 < A.length) && (A[p1] != elem)) {
	    return (p1 + 1);
	} else {
	    return p1;
	}
    }
    public static void main(String[] args) {
	removeElement solution = new removeElement();
	int[] list = {1, 1, 2, 1};
	int newLen = solution.removeElement(list, 2);
	for (int i = 0; i < newLen; i++) {
	    System.out.println(list[i]);
	}
    }
}