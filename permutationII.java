import java.util.*;

public class permutationII {
    void search(List<Integer> list, List<List<Integer>> res, List<Integer> curr) {
	if (list.size() == 0) {
	    List<Integer> copy = new ArrayList<Integer>();
	    copy.addAll(curr);
	    res.add(copy);
	    return;
	}
	for (int i = 0; i < list.size(); i++) {
	    if ((i > 0) && (list.get(i) == list.get(i - 1))) {
		continue;
	    }
	    curr.add(list.remove(i));
	    search(list, res, curr);
	    list.add(i, curr.remove(curr.size() - 1));
	}
    }
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
	List<Integer> list = new ArrayList<Integer>();
	for (int i = 0; i < num.length; i++) {
	    list.add(num[i]);
	}
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> curr = new ArrayList<Integer>();
	search(list, res, curr);
	return res;
    }
    public static void main(String[] args) {
	permutationII solution = new permutationII();
	int[] num = {1, 1, 2};
	System.out.println(solution.permuteUnique(num));
    }
}