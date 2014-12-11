import java.util.*;

public class grayCode {
    public List<Integer> grayCode(int n) {
	List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < (1 << n); i++) {
	    list.add((i >> 1) ^ i);
	}
	return list;
    }
    public static void main(String[] args) {
	grayCode solution = new grayCode();
	System.out.println(solution.grayCode(2));
    }
}