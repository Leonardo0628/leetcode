public class climbStair {
    public int climbStairs(int n) {
        int[] f = new int[Math.max(n + 1, 2)];
	f[0] = 1;
	f[1] = 1;
	for (int i = 2; i <= n; i++) {
	    f[i] = f[i - 1] + f[i - 2];
	}
	return f[n];
    }
    public static void main(String[] args) {
	climbStair solution = new climbStair();
	System.out.println(solution.climbStairs(0));
	System.out.println(solution.climbStairs(1));
	System.out.println(solution.climbStairs(3));
	System.out.println(solution.climbStairs(10));
    }
}