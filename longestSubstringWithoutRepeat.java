import java.util.*;

public class longestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
	// Two pointers
	int p1 = 0, p2 = 0, max = 0;
	while (p2 < s.length()) {
	    // Keep moving if no chars repeated
	    while ((p2 < s.length()) && (!map.containsKey(s.charAt(p2)))) {
		map.put(s.charAt(p2), p2);
		p2++;
	    }
	    max = Math.max(max, p2 - p1);
	    if (p2 < s.length()) {
		int newStart = map.get(s.charAt(p2)) + 1;
		for (int i = p1; i <= newStart - 1; i++) {
		    map.remove(s.charAt(i));
		}
		p1 = newStart;
	    }
	}
	return max;
    }
    public static void main(String[] args) {
	longestSubstringWithoutRepeat solution = new longestSubstringWithoutRepeat();
	System.out.println(solution. lengthOfLongestSubstring("abcabcbb"));
	System.out.println(solution. lengthOfLongestSubstring("bbbbb"));
	System.out.println(solution. lengthOfLongestSubstring(""));
	System.out.println(solution. lengthOfLongestSubstring("a"));
    }
}