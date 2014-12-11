public class singleNum {
    public int singleNumber(int[] A) {
        int res = A[0];
	for (int i = 1; i < A.length; i++) {
	    res ^= A[i];
	}
	return res;
    }
    public static void main(String[] args) {
	singleNum solution = new singleNum();
	int[] list = {296, 1127, 38, 296, 1127};
	System.out.println(solution.singleNumber(list));
    }
}