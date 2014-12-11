import java.util.*;

public class minimumWindowSubstring {
    public String minWindow(String S, String T) {
        int count = T.length();
	Map<Character, Integer> Tmap = new HashMap<Character, Integer>();
	for (int i = 0; i < T.length(); i++) {
	    if (Tmap.containsKey(T.charAt(i))) {
		Tmap.put(T.charAt(i), Tmap.get(T.charAt(i)) + 1);
	    } else {
		Tmap.put(T.charAt(i), 1);
	    }
	}
	int minStart = 0, minEnd = S.length();
	// Two pointers
	int start = -1, end = -1;
	while (start < S.length()) {
	    if ((start >= 0) && (Tmap.containsKey(S.charAt(start)))) {
		if (Tmap.get(S.charAt(start)) >= 0) {
		    count++;
		}
		Tmap.put(S.charAt(start), Tmap.get(S.charAt(start)) + 1);
	    }
	    start++;
	    while ((end + 1 < S.length()) && (count > 0)) {
		end++;
		if (Tmap.containsKey(S.charAt(end))) {
		    if (Tmap.get(S.charAt(end)) > 0) {
			count--;
		    }
		    Tmap.put(S.charAt(end), Tmap.get(S.charAt(end)) - 1);
		}
	    }
	    if ((count == 0) && (end - start < minEnd - minStart)) {
		minStart = start;
		minEnd = end;
	    }
	}
	if (minEnd == S.length()) {
	    return "";
	} else {
	    return S.substring(minStart, minEnd + 1);
	}
    }
    public static void main(String[] args) {
	minimumWindowSubstring solution = new minimumWindowSubstring();
	System.out.println(solution.minWindow("ab", "a"));
    }
}