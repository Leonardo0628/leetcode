public class int2Roman {
    public String intToRoman(int num) {
        int[] digit = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	int tmp = num;
	String roman = "";
	for (int i = 0; i < digit.length; i++) {
	    String curr = "";
	    while (tmp >= digit[i]) {
		curr += strs[i];
		tmp -= digit[i];
	    }
	    roman += curr;
	}
	return roman;
    }
    public static void main(String[] args) {
	int2Roman solution = new int2Roman();
	System.out.println(solution.intToRoman(2014));
	System.out.println(solution.intToRoman(9));
    }
}