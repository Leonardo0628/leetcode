public class power {
    public double pow(double x, int n) {
	if (n == 0) {
	    return 1;
	} else if (n < 0) {
	    return (pow(1 / x, - 1 - n) / x); // Avoid overflow when n = -2147483648
	} else {
	    int half = n / 2;
	    double halfPower = pow(x, half);
	    if (n % 2 == 0) {
		return (halfPower * halfPower);
	    } else {
		return (halfPower * halfPower * x);
	    }
	}	
    }
    public static void main(String[] args) {
	power solution = new power();
	System.out.println(solution.pow(3, 0));
	System.out.println(solution.pow(3, 1));
	System.out.println(solution.pow(3, -1));
	System.out.println(solution.pow(3, -5));
	System.out.println(solution.pow(1.00000, -2147483648));
    }
}