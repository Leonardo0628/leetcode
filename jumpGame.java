public class jumpGame {
    public boolean canJump(int[] A) {
	int jumpMax = 0, start = 0;
	for (int i = 0; i < A.length; i++) {
	    if (i > jumpMax) {
		return false;
	    }
	    jumpMax = Math.max(jumpMax, i + A[i]);
	    if (jumpMax >= A.length - 1) {
		return true;
	    }
	}
	return (jumpMax >= A.length - 1);
    }
    public static void main(String[] args) {
	jumpGame solution = new jumpGame();
	int[] list = {2, 3, 1, 1, 4};
	//int[] list = {3, 2, 1, 0, 4};
	//int[] list = {0};
	//int[] list = {5, 0};
	System.out.println(solution.canJump(list));
    }
}
