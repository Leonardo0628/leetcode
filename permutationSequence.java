import java.util.*;

public class permutationSequence {
    public String getPermutation(int n, int k) {
        String res = "";
	int[] fac = new int[n + 1];
	List<Integer> list = new LinkedList<Integer>();
	fac[0] = 1;
	for (int i = 1; i <= n; i++) {
	    fac[i] = fac[i - 1] * i;
	    list.add(i);
	}
	int choice = k - 1;
	for (int i = 1; i <= n; i++) {
	    res = res + list.get(choice / fac[n - i]);
	    list.remove(choice / fac[n - i]);
	    choice = choice % fac[n - i];
	}
	return res;
    }
    public static void main(String[] args) {
	permutationSequence solution = new permutationSequence();
	System.out.println(solution.getPermutation(3, 5));
	System.out.println(solution.getPermutation(1, 1));
	System.out.println(solution.getPermutation(9, 1));
	System.out.println(solution.getPermutation(9, 362880));
    }
}