import java.util.*;

public class wordBreak {
    // Dynamic programming: Time complexity O(n^2)
    public boolean wordBreak(String s, Set<String> dict) {
	boolean[] segment = new boolean[s.length() + 1];
	segment[0] = true;
	for (int i = 0; i < s.length(); i++) {
	    segment[i + 1] = false;
	    for (int j = 0; j <= i; j++) {
		if (segment[j]) {
		    if (dict.contains(s.substring(j, i + 1))) {
			segment[i + 1] = true;
			break;
		    }
		}
	    }
	}
        return segment[s.length()];
    }
    public static void main(String[] args) {
	wordBreak solution = new wordBreak();
	System.out.println(solution.wordBreak("leetcode", new HashSet(Arrays.asList("leet", "code"))));
    }
}