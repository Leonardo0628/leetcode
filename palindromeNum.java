public class palindromeNum {
    public boolean isPalindrome(int x) {
	// Negative integers were not considered as palindromes
        if (x < 0) {
	    return false;
	}
	int div = 1, tmp = x;
	while (tmp > 9) {
	    tmp /= 10;
	    div *= 10;
	}
	while (div >= 10) {
	    if (x % 10 != x / div) {
		return false;
	    }
	    x = (x % div) / 10;
	    div /= 100;
	}
	return true;
    }
    public static void main(String[] args) {
	palindromeNum solution = new palindromeNum();
	System.out.println(solution.isPalindrome(-1));
	System.out.println(solution.isPalindrome(121));
	System.out.println(solution.isPalindrome(1000021));
    }
}