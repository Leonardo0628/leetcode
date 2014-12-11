public class multiplyStr {
    public String multiply(String num1, String num2) {
	int[] prod = new int[num1.length() + num2.length()];
	for (int i = 0; i < (num1.length() + num2.length()); i++) {
	    prod[i] = 0;
	}
	for (int i = 0; i < num1.length(); i++) {
	    for (int j = 0; j < num2.length(); j++) {
		prod[i + j] += (num1.charAt(num1.length() - i - 1) - '0') * (num2.charAt(num2.length() - j - 1) - '0');
	    }
	}
	String res = "";
	for (int i = 0; i < (num1.length() + num2.length() - 1); i++) {
	    prod[i + 1] += prod[i] / 10;
	    prod[i] %= 10;
	    res = prod[i] + res;
	}
	res = prod[num1.length() + num2.length() - 1] + res;
	while ((res.length() > 1) && (res.charAt(0) == '0')) {
	    res = res.substring(1, res.length());
	}
	return res;
    }
    public static void main(String[] args) {
        multiplyStr solution = new multiplyStr();
	System.out.println(solution.multiply("100", "10"));
	System.out.println(solution.multiply("99", "999"));
	System.out.println(solution.multiply("999", "0"));
    }
}