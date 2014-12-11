public class atoi {
    public int atoi(String str) {
	String trim = str.trim();
	if (trim.length() == 0) {
	    return 0;
	}
	long val = 0;
	int sign = 1;
	if (trim.charAt(0) == '-') {
	    sign = -1;
	    trim = trim.substring(1);
	} else if (trim.charAt(0) == '+') {
	    trim = trim.substring(1);
 	}
	for (int i = 0; i < trim.length(); i++) {
	    if ((trim.charAt(i) >= '0') && (trim.charAt(i) <= '9')) {
		val = val * 10 + (trim.charAt(i) - '0');
	    } else {
		break;
	    }
	    if (sign * val > Integer.MAX_VALUE) {
		return Integer.MAX_VALUE;
	    } else if (sign * val < Integer.MIN_VALUE) {
	    	return Integer.MIN_VALUE;
	    }
	}
	val *= sign;
	return (int)val;
    }
    public static void main(String[] args) {
	atoi solution = new atoi();
	System.out.println(solution.atoi("  -123.45"));
	System.out.println(solution.atoi("  +3000000000.11"));
    }
}