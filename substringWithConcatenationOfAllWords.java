import java.util.*;

public class substringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
	List<Integer> index = new ArrayList<Integer>();
	for (int i = 0; i < L[0].length(); i++) {
	    int count = L.length;
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    for (int j = 0; j < L.length; j++) {
		if (map.containsKey(L[j])) {
		    map.put(L[j], map.get(L[j]) + 1);
		} else {
		    map.put(L[j], 1);
		}
	    }
	    int start = i - L[0].length();
	    while (start + L[0].length() <= S.length() - L.length * L[0].length()) {
		if (start >= i) {
		    String word = S.substring(start, start + L[0].length());
		    if (map.containsKey(word)) {
			map.put(word, map.get(word) + 1);
			count++;
		    }
		}
		start += L[0].length();
		int left = count, end = start + (L.length - count) * L[0].length();
		for (int j = 0; j < left; j++) {
		    String word = S.substring(end + j * L[0].length(), end + (j + 1) * L[0].length());
		    if ((map.containsKey(word)) && (map.get(word) > 0)) {
			map.put(word, map.get(word) - 1);
			count--;
		    } else {
			break;
		    }
		}
		if (count == 0) {
		    index.add(start);
		}
	    }
	}
	return index;
    }
    public static void main(String[] args) {
	substringWithConcatenationOfAllWords solution = new substringWithConcatenationOfAllWords();
	String S = "barfoothefoobarman";
	String[] L = {"foo", "bar"};
	System.out.println(solution.findSubstring(S, L));
    }
}