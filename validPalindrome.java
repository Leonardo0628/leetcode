public class validPalindrome {
    public boolean isPalindrome(String s) {
	String sClean = s.replaceAll("[^a-zA-Z0-9]+", "");
	sClean = sClean.toLowerCase();
	int start = 0, end = sClean.length() - 1;
	while (start < end) {
	    if (sClean.charAt(start) != sClean.charAt(end)) {
		return false;
	    }
	    start++;
	    end--;
	}
        return true;
    }
    public static void main(String[] args) {
	validPalindrome solution = new validPalindrome();
	System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
	System.out.println(solution.isPalindrome("race a car"));
	System.out.println(solution.isPalindrome(" "));
	System.out.println(solution.isPalindrome(""));
	System.out.println(solution.isPalindrome("1a2"));
    }
}