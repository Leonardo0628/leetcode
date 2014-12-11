public class strStr {
    // Time complexity: O(haystack.length() * needle.length())
    // KMP algorithm can achieve complexity O(haystack.length() + needle.length())
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
	    boolean flag = true;
	    for (int j = 0; j < needle.length(); j++) {
		if (haystack.charAt(i + j) != needle.charAt(j)) {
		    flag = false;
		    break;
		}
	    }
	    if (flag) {
		return i;
	    }
	}
	return -1;
    }
    public static void main(String[] args) {
	strStr solution = new strStr();
	System.out.println(solution.strStr("EABABCDAB", "ABC"));
    }
}