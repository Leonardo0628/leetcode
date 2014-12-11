public class divide2Int {
    public int divide(int dividend, int divisor) {
	long res = dividend;
	int sign = 1, ans = 0;
        if ((dividend > 0) && (divisor < 0)) {
            sign = -1;
	} else if ((dividend < 0) && (divisor > 0)) {
	    sign = -1;
	}
	while (Math.abs(res) > 0) {
	    long quotient = 1, sub = divisor;
	    while (Math.abs(sub) <= Math.abs(res)) {
		quotient <<= 1;
		sub <<= 1;
	    }
	    quotient >>= 1;
	    sub >>= 1;
	    if (quotient > 0) {
		if (sign == 1) {
		    ans += quotient;
		    res -= sub;
		} else {
		    ans -= quotient;
		    res += sub;
		}
	    } else {
	        break;
	    }
	}
	return ans;
    }
    public static void main(String[] args) {
        divide2Int solution = new divide2Int();
	System.out.println(solution.divide(0, 3));
	System.out.println(solution.divide(2, 3));
	System.out.println(solution.divide(-1, 3));
	System.out.println(solution.divide(3, 3));
	System.out.println(solution.divide(-3, 3));
	System.out.println(solution.divide(9, 3));
	System.out.println(solution.divide(Integer.MAX_VALUE, 1));
	System.out.println(solution.divide(Integer.MAX_VALUE, -1));
	System.out.println(solution.divide(Integer.MIN_VALUE, 1));
    }
}