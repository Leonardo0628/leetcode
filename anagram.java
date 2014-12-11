import java.util.*;

public class anagram {
    public List<String> anagrams(String[] strs) {
	List<String> out = new LinkedList<String>();
	Map<String, List<String>> map = new HashMap<String, List<String>>();
	for (int i = 0; i < strs.length; i++) {
	    char[] splitStr = strs[i].toCharArray();
	    Arrays.sort(splitStr);
	    String sortStr = new String(splitStr);
	    if (map.containsKey(sortStr)) {
		map.get(sortStr).add(strs[i]);
	    } else {
		List<String> list = new LinkedList<String>();
		list.add(strs[i]);
		map.put(sortStr, list);
	    }
	}
	Set<String> set = map.keySet();
	Iterator<String> iter = set.iterator();
	while (iter.hasNext()) {
	    String key = iter.next();
	    if (map.get(key).size() > 1) {
		out.addAll(map.get(key));
	    }
	}
	return out;
    }
    public static void main(String[] args) {
	anagram solution = new anagram();
	String[] strs = {"cat","rye","aye","dog", "god","cud","cat","old","fop","bra"};
	System.out.println(solution.anagrams(strs));
    }
}