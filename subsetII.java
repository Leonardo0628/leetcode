import java.util.*;

public class subsetII {
    public List<List<Integer>> subsetsWithDup(int[] S) {
	List<List<Integer>> list = new LinkedList<List<Integer>>();
	List<Integer> uniq = new LinkedList<Integer>();
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	for (int i = 0; i < S.length; i++) {
	    if (map.containsKey(S[i])) {
		map.put(S[i], map.get(S[i]) + 1);
	    } else {
		map.put(S[i], 1);
		uniq.add(S[i]);
	    }
	}
	Collections.sort(uniq);
	int num = 1;
	for (int i = 0; i < uniq.size(); i++) {
	    num *= map.get(uniq.get(i)) + 1;
	}
	for (int i = 0; i < num; i++) {
	    int choice = i;
	    List<Integer> sub = new LinkedList<Integer>();
	    for (int j = 0; j < uniq.size(); j++) {
		for (int k = 1; k <= choice % (map.get(uniq.get(j)) + 1); k++) {
		    sub.add(uniq.get(j));
		}
		choice /= map.get(uniq.get(j)) + 1;
	    }
	    list.add(sub);
	}
	return list;
    }
    public static void main(String[] args) {
	subsetII solution = new subsetII();
	int[] s = {1, 2, 2};
	System.out.println(solution.subsetsWithDup(s));
    }
}