import java.util.*;

public class combinationSum {
    void findSum(List<List<Integer>> res, List<Integer> curr, List<Integer> unique, int target, int start) {
	if (target == 0) {
	    List<Integer> copy = new LinkedList<Integer>();
	    copy.addAll(curr);
	    res.add(copy);
	    return;
	}
	for (int i = start; i < unique.size(); i++) {
	    if (target >= unique.get(i)) {
		curr.add(unique.get(i));
		findSum(res, curr, unique, target - unique.get(i), i);
		curr.remove(curr.size() - 1);
	    }
	}
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	List<List<Integer>> res = new LinkedList<List<Integer>>();
	// Keep unique numbers in candidates
	Set<Integer> set = new HashSet<Integer>();
	for (int i = 0; i < candidates.length; i++) {
	    set.add(candidates[i]);
	}
	List<Integer> unique = new LinkedList<Integer>();
	Iterator<Integer> iter = set.iterator();
	while (iter.hasNext()) {
	    unique.add(iter.next());
	}
	Collections.sort(unique);
	List<Integer> curr = new LinkedList<Integer>();
	findSum(res, curr, unique, target, 0);
	return res;
    }
    public static void main(String[] args) {
	combinationSum solution = new combinationSum();
	int[] candidates = {2, 2, 3, 6, 7};
	System.out.println(solution.combinationSum(candidates, 7));
    }
}