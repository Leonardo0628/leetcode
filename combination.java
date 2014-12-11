import java.util.*;

public class combination {
    void choose(int n, int k, List<Integer> curr, List<List<Integer>> list) {
	if (curr.size() == k) {
	    List<Integer> copy = new ArrayList<Integer>();
	    copy.addAll(curr);
	    list.add(copy);
	} else {
	    int start = 1;
	    if (curr.size() > 0) {
		start = curr.get(curr.size() - 1) + 1;
	    }
	    for (int i = start; i <= n; i++) {
		curr.add(i);
		choose(n, k, curr, list);
		curr.remove(curr.size() - 1);
	    }
	}
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
	List<Integer> curr = new ArrayList<Integer>();
	choose(n, k, curr, list);
	return list;
    }
    public static void main(String[] args) {
	combination solution = new combination();
	System.out.println(solution.combine(4, 2));
	System.out.println(solution.combine(4, 0));
	System.out.println(solution.combine(4, 4));
	System.out.println(solution.combine(1, 0));
	System.out.println(solution.combine(1, 1));
    }
}