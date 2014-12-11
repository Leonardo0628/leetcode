import java.util.*;

public class pascalTriII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<Integer>();
	list.add(1);
	for (int i = 1; i <= rowIndex; i++) {
	    list.add((new Double(list.get(list.size() - 1) * 1.0 * (rowIndex + 1 - i) / i)).intValue());
	}
	return list;
    }
    public static void main(String[] args) {
	pascalTriII solution = new pascalTriII();
	System.out.println(solution.getRow(3));
	System.out.println(solution.getRow(32));
    }
}