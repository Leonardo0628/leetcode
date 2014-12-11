public class uniqueBST {
    public int numTrees(int n) {
        int[] num = new int[n + 1];
	num[0] = 1;
	for (int i = 1; i <= n; i++) {
	    num[i] = 0;
	    for (int j = 1; j <= i; j++) {
		num[i] += num[j - 1] * num[i - j];
	    }
	}
	return num[n];
    }
    public static void main(String[] args) {
	uniqueBST solution = new uniqueBST();
	System.out.println(solution.numTrees(1));
	System.out.println(solution.numTrees(3));
	System.out.println(solution.numTrees(5));
    }
}