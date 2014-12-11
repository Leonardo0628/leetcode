import java.util.*;

public class singleNumII {
    public int singleNumber(int[] A) {
        int[] bit = new int[32];
	for (int i = 0; i < bit.length; i++) {
	    bit[i] = 0;
	}
	for (int i = 0; i < A.length; i++) {
	    for (int j = 0; j < bit.length; j++) {
		bit[j] += (A[i] >> j) & 1;
	    }
	}
	int single = 0, power = 1;
	for (int i = 0; i < bit.length; i++) {
	    single += ((bit[i] % 3) << i);
	}
	return single;
    }
    public static void main(String[] args) {
	singleNumII solution = new singleNumII();
	int[] num = {-2, -2, 1, 1, -3, 1, -3, -3, -4, -2};
	int[] num2 = {43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43};
	System.out.println(solution.singleNumber(num));
	System.out.println(solution.singleNumber(num2));
    }
}