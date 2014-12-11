public class addBin {
    public String addBinary(String a, String b) {
	String sum = "";
	int curr = 0, p1 = a.length() - 1, p2 = b.length() - 1;
	while ((p1 >= 0) || (p2 >= 0)) {
	    if (p1 >= 0) {
		curr += a.charAt(p1) - '0';
		p1--;
	    }
	    if (p2 >= 0) {
		curr += b.charAt(p2) - '0';
		p2--;
	    }
	    sum = (char)(curr % 2 + '0') + sum;
	    curr /= 2;
	}
	while (curr != 0) {
	    sum = (char)(curr % 2 + '0') + sum;
	    curr /= 2;
	}
	return sum;
    }
    public static void main(String[] args) {
	addBin solution = new addBin();
	System.out.println(solution.addBinary("1", "1"));
    }
}