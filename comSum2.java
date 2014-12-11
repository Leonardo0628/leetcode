import java.util.*;

public class comSum2 {
    void findSum(List<List<Integer>> res, List<Integer> curr, int[] candidates, int target, int pre) {
	if (target == 0) {
	    List<Integer> copy = new LinkedList<Integer>();
	    copy.addAll(curr);
	    res.add(copy);
	    return;
	}
	for (int i = pre + 1; i < candidates.length; i++) {
	    if ((i > 0) && (candidates[i] == candidates[i - 1]) && (pre != i - 1)) {
		continue;
	    }
	    if (target >= candidates[i]) {
		curr.add(candidates[i]);
		findSum(res, curr, candidates, target - candidates[i], i);
		curr.remove(curr.size() - 1);
	    }
	}
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	List<List<Integer>> res = new LinkedList<List<Integer>>();
	Arrays.sort(candidates);
	List<Integer> curr = new LinkedList<Integer>();
	findSum(res, curr, candidates, target, -1);
	return res;
    }
    public static void main(String[] args) {
	comSum2 solution = new comSum2();
	int[] candidates = {10, 1, 2, 7, 6, 1, 5};
	System.out.println(solution.combinationSum2(candidates, 8));
    }
}