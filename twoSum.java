import java.util.*;

public class twoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	int i;
	for (i = 0; i < numbers.length; i++) {
	    if (map.containsKey(target - numbers[i])) {
		break;
	    }
	    map.put(numbers[i], i);
	}
	int[] out = {map.get(target - numbers[i]) + 1, i + 1};
	return out;
    }
    public static void main(String[] args) {
	twoSum solution = new twoSum();
	int[] num = {2, 7, 11, 15};
	int[] idx = solution.twoSum(num, 9);
	System.out.println(idx[0] + " " + idx[1]);
    }
}