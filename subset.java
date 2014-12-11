import java.util.*;

public class subset {
    public List<List<Integer>> subsets(int[] S) {
	List<List<Integer>> list = new LinkedList<List<Integer>>();
	Arrays.sort(S);
	for (int i = 0; i < Math.pow(2, S.length); i++) {
	    List<Integer> sub = new LinkedList<Integer>();
	    int choice = i;
	    for (int j = S.length - 1; j >= 0; j--) {
		if (choice % 2 == 1) {
		    sub.add(0, S[j]);
		}
		choice >>= 1;
	    }
	    list.add(sub);
	}
	return list;
    }
    public static void main(String[] args) {
	subset solution = new subset();
	int[] s = {1, 2, 3};
	System.out.println(solution.subsets(s));
    }
}