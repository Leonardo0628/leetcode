public class decode {
    public int numDecodings(String s) {
        if ((s.length() == 0) || (s.charAt(0) == '0')) {
	    return 0;
	}
	int[] num = new int[s.length()];
	num[0] = 1;
	for (int i = 1; i < s.length(); i++) {
	    if (s.charAt(i) == '0') {
		num[i] = 0;
	    } else {
		num[i] = num[i - 1];
	    }
	    int code = new Integer(s.substring(i - 1, i + 1));
	    if ((code >= 10) && (code <= 26)) {
		if (i > 1) {
		    num[i] += num[i - 2];
		} else {
		    num[i]++;
		}
	    }
	}
	return num[s.length() - 1];
    }
    public static void main(String[] args) {
	decode solution = new decode();
	System.out.println(solution.numDecodings(""));
	System.out.println(solution.numDecodings("12"));
	System.out.println(solution.numDecodings("31026"));
    }
}