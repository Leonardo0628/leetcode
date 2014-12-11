import java.util.*;

public class permutation {
    void travel(List<Integer> list, List<Integer> curr, List<List<Integer>> res) {
	if (list.size() == 0) {
	    List<Integer> copy = new LinkedList<Integer>();
	    copy.addAll(curr);
	    res.add(copy);
	    return;
	}
	for (int i = 0; i < list.size(); i++) {
	    curr.add(list.remove(i));
	    travel(list, curr, res);
	    list.add(i, curr.remove(curr.size() - 1));
	}
    }
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
	List<Integer> curr = new LinkedList<Integer>();
	List<Integer> list = new LinkedList<Integer>();
	for (int i = 0; i < num.length; i++) {
	    list.add(num[i]);
	}
	travel(list, curr, res);
	return res;
    }
    public static void main(String[] args) {
	permutation solution = new permutation();
	int[] list = {1, 2, 3};
	System.out.println(solution.permute(list));
    }
}