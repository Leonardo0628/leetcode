public class zigzagConversion {
    public String convert(String s, int nRows) {
	if (nRows == 1) {
	    return s;
	}
	String out = "";
	for (int i = 1; i <= nRows; i++) {
	    int j = i - 1;
	    if (j < s.length()) {
		out = out + s.charAt(j);
	    } else {
		break;
	    }
	    while (j < s.length()) {
		int s1 = 2 * (nRows - i);
		if (s1 > 0) {
		    j = j + s1;
		    if (j < s.length()) {
			out = out + s.charAt(j);
		    } else {
			break;
		    }
		}
		int s2 = 2 * i - 2;
		if (s2 > 0) {
		    j = j + s2;
		    if (j < s.length()) {
			out = out + s.charAt(j);
		    } else {
			break;
		    }
		}
	    }
	}
	return out;
    }
    public static void main(String[] args) {
	zigzagConversion solution = new zigzagConversion();
	System.out.println(solution.convert("PAYPALISHIRING", 3));
	System.out.println(solution.convert("PAYPALISHIRING", 5));
	System.out.println(solution.convert("PAYPALISHIRING", 1));
    }
}