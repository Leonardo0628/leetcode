import java.util.*;

public class triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
	if (triangle.size() == 0) {
	    return 0;
	}
	int[][] f = new int[2][triangle.size()];
	f[0][0] = triangle.get(0).get(0);
	int flag = 1;
	for (int i = 1; i < triangle.size(); i++) {
	    f[flag][0] = f[1-flag][0] + triangle.get(i).get(0);
	    for (int j = 1; j < i; j++) {
		f[flag][j] = Math.min(f[1-flag][j-1], f[1-flag][j]) + triangle.get(i).get(j);
	    }
	    f[flag][i] = f[1-flag][i-1] + triangle.get(i).get(i);
	    flag = 1 - flag;
	}
	int min = f[1-flag][0];
	for (int i = 1; i < triangle.size(); i++) {
	    min = Math.min(min, f[1-flag][i]);
	}
	return min;
    }
    public static void main(String[] args) {
	triangle solution = new triangle();
	List<List<Integer>> tri = new ArrayList<List<Integer>>();
	System.out.println(solution.minimumTotal(tri));
	tri.add(Arrays.asList(2));
	System.out.println(solution.minimumTotal(tri));
	tri.add(Arrays.asList(3, 4));
	tri.add(Arrays.asList(6, 5, 7));
	tri.add(Arrays.asList(4, 1, 8, 3));
	System.out.println(solution.minimumTotal(tri));
    }
}