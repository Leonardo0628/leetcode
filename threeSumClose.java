import java.util.*;

public class threeSumClose {
    // Time complexity: O(n^2)
    public int threeSumClosest(int[] num, int target) {
	int close = num[0] + num[1] + num[2];
	Arrays.sort(num);
	// Enumerate the first number
	for (int i = 0; i < num.length - 2; i++) {
	    int p1 = i + 1, p2 = num.length - 1;
	    while (p1 < p2) {
		int sum = num[i] + num[p1] + num[p2];
		if (Math.abs(sum - target) < Math.abs(close - target)) {
		    close = sum;
		}    
		if (sum == target) {
		    return close;
		} else if (sum > target) {
		    p2--;
		} else {
		    p1++;
		}
	    }
	}
	return close;
    }
    public static void main(String[] args) {
	threeSumClose solution = new threeSumClose();
	int[] num = {-1, 2, 1, -4};
	System.out.println(solution.threeSumClosest(num, 1));
    }
}