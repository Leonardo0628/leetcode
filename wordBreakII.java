import java.util.*;

public class wordBreakII {
    private boolean wordBreakI(String s, Set<String> dict) {
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
    private void travel(String s, Set<String> dict, String curr, List<String> segment) {
	if (dict.contains(s)) {
	    segment.add(curr + s);
	}
	for (int i = 0; i < s.length() - 1; i++) {
	    String word = s.substring(0, i + 1);
	    if (dict.contains(word)) {
		travel(s.substring(i + 1, s.length()), dict, curr + word + " ", segment);
	    }
	}
    }
    public List<String> wordBreak(String s, Set<String> dict) {
	if (!wordBreakI(s, dict)) {
	    return new ArrayList<String>();
	}
	List<String> segment = new ArrayList<String>();
	travel(s, dict, "", segment);
	return segment;
    }
    public static void main(String[] args) {
	wordBreakII solution = new wordBreakII();
	System.out.println(solution.wordBreak("catsanddog", new HashSet(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
	System.out.println(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", new HashSet(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))));
    }
}