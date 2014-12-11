import java.util.*;

public class letterCombinationOfPhoneNum {
    public List<String> letterCombinations(String digits) {
	Map<Character, String> map = new HashMap<Character, String>();
        LinkedList<String> queue = new LinkedList<String>();
	map.put('2', "abc");
	map.put('3', "def");
	map.put('4', "ghi");
	map.put('5', "jkl");
	map.put('6', "mno");
	map.put('7', "pqrs");
	map.put('8', "tuv");
	map.put('9', "wxyz");
	queue.offer("");
	if ((digits.length() == 0) || (digits.contains("0")) || (digits.contains("1"))) {
	    return queue;
	}
	for (int i = 0; i < digits.length(); i++) {
	    while ((queue.size() > 0) && (queue.peek().length() == i)) {
		String curr = queue.poll(), candidate = map.get(digits.charAt(i));
		for (int j = 0; j < candidate.length(); j++) {
		    queue.offer(curr + candidate.charAt(j));
		}
	    }
	}
	return queue;
    }
    public static void main(String[] args) {
	letterCombinationOfPhoneNum solution = new letterCombinationOfPhoneNum();
	System.out.println(solution.letterCombinations(""));
	System.out.println(solution.letterCombinations("9"));
	System.out.println(solution.letterCombinations("23"));
	System.out.println(solution.letterCombinations("468"));
	System.out.println(solution.letterCombinations("41204"));
    }
}