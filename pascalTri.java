import java.util.*;

public class pascalTri {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new LinkedList<List<Integer>>();
	for (int i = 1; i <= numRows; i++) {
	    List<Integer> row = new LinkedList<Integer>(Arrays.asList(1));
	    for (int j = 0; j < i - 2; j++) {
		row.add(tri.get(i - 2).get(j) + tri.get(i - 2).get(j + 1));
	    }
	    if (i > 1) {
		row.add(1);
	    }
	    tri.add(row);
	}
	return tri;
    }
    public static void main(String[] args) {
	pascalTri solution = new pascalTri();
	System.out.println(solution.generate(0));
	System.out.println(solution.generate(1));
	System.out.println(solution.generate(5));
	System.out.println(solution.generate(32));
    }
}