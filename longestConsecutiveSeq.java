import java.util.*;

public class longestConsecutiveSeq {
    public int longestConsecutive(int[] num) {
	int maxCount = 0;
	Set<Integer> set = new HashSet<Integer>();
	for (int i = 0; i < num.length; i++) {
	    set.add(num[i]);
	}
	for (int i = 0; i < num.length; i++) {
	    if (set.contains(num[i])) {
		int count = 1;
		int j = num[i] + 1;
		while (set.contains(j)) {
		    count++;
		    set.remove(j);
		    j++;
		}
		j = num[i] - 1;
		while (set.contains(j)) {
		    count++;
		    set.remove(j);
		    j--;
		}
		maxCount = Math.max(maxCount, count);
	    }
	}
	return maxCount;
    }
    public static void main(String[] args) {
	longestConsecutiveSeq solution = new longestConsecutiveSeq();
	int[] num = {100, 4, 200, 1, 3, 2};
	System.out.println(solution.longestConsecutive(num));
    }
}