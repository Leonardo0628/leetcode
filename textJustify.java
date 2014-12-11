import java.util.*;

public class textJustify {
    public List<String> fullJustify(String[] words, int L) {
	List<String> justify = new LinkedList<String>();
	int start = 0, end = 0, count = words[0].length();
	String curr = words[0];
	while (end < words.length) {
	    while ((end + 1 < words.length) && (count + words[end + 1].length() + 1 <= L)) {
		end++;
		count += words[end].length() + 1;
	    }
	    if (end == words.length - 1) {
		break;
	    }
	    int blank = L - count + (end - start);
	    for (int i = start + 1; i <= end; i++) {
		int pad = (int)Math.ceil(blank * 1.0 / (end - i + 1));
		for (int j = 1; j <= pad; j++) {
		    curr += " ";
		}
		blank -= pad;
		curr += words[i];
	    }
	    for (int j = 1; j <= blank; j++) {
		curr += " ";
	    }
	    justify.add(curr);
	    start = end + 1;
	    end = start;
	    count = words[start].length();
	    curr = words[start];
	}
	// Last line
	int blank = L - count + (end - start);
	for (int i = start + 1; i <= end; i++) {
	    curr += " " + words[i];
	    blank--;
	}
	for (int j = 1; j <= blank; j++) {
	    curr += " ";
	}
	justify.add(curr);
	return justify;
    }
    public static void main(String[] args) {
	textJustify solution = new textJustify();
	String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
	System.out.println(solution.fullJustify(words, 16));
    }
}