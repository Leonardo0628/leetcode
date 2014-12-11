public class sqrt {
    // Binary search
    public int sqrt(int x) {
	long start = 0, end = x, mid;
	while (start < end) {
	    mid = (start + end + 1) / 2;
	    if (mid * mid == x) {
		return (int)mid;
	    } else if (mid * mid < x) {
		start = mid;
	    } else {
		end = mid - 1;
	    }
	}
	return (int)start;
    }
    // Newton method: Solve f(y) = y ^ 2 - x = 0
    //   ==> y = y - f(y) / f'(y)
    public int sqrt2(int x) {
	double oldSol = 0, newSol = x;
	while (Math.abs(newSol * newSol - x) > 1e-3) {
	    oldSol = newSol;
	    newSol = (oldSol * oldSol + x) / (2 * oldSol);
	}
	return (int)newSol;
    }
    public static void main(String[] args) {
	sqrt solution = new sqrt();
	System.out.println(solution.sqrt(0));
	System.out.println(solution.sqrt(1));
	System.out.println(solution.sqrt(2));
	System.out.println(solution.sqrt(4));
	System.out.println(solution.sqrt(8));
	System.out.println(solution.sqrt(9));
	System.out.println(solution.sqrt(10));
	System.out.println(solution.sqrt(32000));
	System.out.println(solution.sqrt(32000 * 32000));
    }
}