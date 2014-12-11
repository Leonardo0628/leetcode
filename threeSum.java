import java.util.*;

public class threeSum {
    // Time complexity: O(n^2)
    public List<List<Integer>> threeSum(int[] num) {
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	Arrays.sort(num);
	// Enumerate the first number
	for (int i = 0; i < num.length - 2; i++) {
	    if ((i > 0) && (num[i] == num[i - 1])) {
		continue;
	    }
	    // Two pointers
	    int p1 = i + 1, p2 = num.length - 1;
	    while (p1 < p2) {
		if (num[i] + num[p1] + num[p2] == 0) {
		    List<Integer> sol = new ArrayList<Integer>();
		    sol.add(num[i]);
		    sol.add(num[p1]);
		    sol.add(num[p2]);
		    list.add(sol);
		    p1++;
		    while ((p1 < p2) && (num[p1] == num[p1 - 1])) {
			p1++;
		    }
		    p2--;
		    while ((p1 < p2) && (num[p2] == num[p2 + 1])) {
			p2--;
		    }
		} else if (num[i] + num[p1] + num[p2] > 0) {
		    p2--;
		} else {
		    p1++;
		}
	    }
	}
	return list;
    }
    public static void main(String[] args) {
	threeSum solution = new threeSum();
	int[] num = {-1, 0, 0, 1, 1, 1, 2, -1, -4};
	System.out.println(solution.threeSum(num));
    }
}