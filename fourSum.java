import java.util.*;

public class fourSum {
    // Time complexity: O(n^3)
    public List<List<Integer>> fourSum(int[] num, int target) {
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	Arrays.sort(num);
	// Enumerate the first number
	for (int i = 0; i < num.length - 3; i++) {
	    if ((i > 0) && (num[i] == num[i - 1])) {
		continue;
	    }
	    // Enumerate the second number
	    for (int j = i + 1; j < num.length - 2; j++) {
		if ((j > i + 1) && (num[j] == num[j - 1])) {
		    continue;
		}
		int p1 = j + 1, p2 = num.length - 1;
		while (p1 < p2) {
		    if (num[i] + num[j] + num[p1] + num[p2] == target) {
			List<Integer> sol = new ArrayList<Integer>();
			sol.add(num[i]);
			sol.add(num[j]);
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
		    } else if (num[p1] + num[p2] + num[i] + num[j] > target) {
			p2--;
		    } else {
			p1++;
		    }
		}
	    }
	}
	return list;
    }
    public static void main(String[] args) {
        fourSum solution = new fourSum();
	int[] num = {1, 0, -1, 0, -2, 2};
	System.out.println(solution.fourSum(num, 0));
    }
}