public class reverseInt {
    public int reverse(int x) {
	long y = 0;
	while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        if ((y > Integer.MAX_VALUE) || (y < Integer.MIN_VALUE)) {
            return 0;
        } else {
            return (int)y;
        }
    }
    public static void main(String[] args) {
	reverseInt solution = new reverseInt();
	System.out.println(solution.reverse(123));
	System.out.println(solution.reverse(-123));
	System.out.println(solution.reverse(1000000003));
    }
}