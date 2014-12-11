public class plusOne {
    public int[] plusOne(int[] digits) {
	for (int i = digits.length - 1; i >= 0; i--) {
	    // Find the first digit less than 9
	    if (digits[i] < 9) {
		int[] out = new int[digits.length];
		for (int j = 0; j <= i; j++) {
		    out[j] = digits[j];
		}
		out[i]++;
		for (int j = i + 1; j < digits.length; j++) {
		    out[j] = 0;
		}
		return out;
	    }
	}
	int[] out = new int[digits.length + 1];
	out[0] = 1;
	for (int j = 1; j <= digits.length; j++) {
	    out[j] = 0;
	}
	return out;
    }
    public int[] plusOne2(int[] digits) {
        int[] list = new int[digits.length];
	for (int i = 0; i < digits.length; i++) {
	    list[i] = digits[i];
	}
	list[list.length - 1]++;
	int add = 0;
	for (int i = list.length - 1; i >= 0; i--) {
	    list[i] += add;
	    add = list[i] / 10;
	    list[i] %= 10;
	    if (add == 0) {
		break;
	    }
	}
	int[] res;
	if (add == 0) {
	    res = new int[digits.length];
	    for (int i = 0; i < digits.length; i++) {
		res[i] = list[i];
	    }
	} else {
	    res = new int[digits.length + 1];
	    res[0] = add;
	    for (int i = 0; i < digits.length; i++) {
		res[i + 1] = list[i];
	    }
	}
	return res;
    }
    public static void main(String[] args) {
	plusOne solution = new plusOne();
	int[] num = {9, 9};
	System.out.println(solution.plusOne(num)[0]);
	System.out.println(solution.plusOne(num)[1]);
	System.out.println(solution.plusOne(num)[2]);
    }
}