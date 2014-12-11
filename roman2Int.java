import java.util.*;

public class roman2Int {
    public int romanToInt(String s) {
	Map<Character, Integer> map = new HashMap<Character, Integer>();
	map.put('I', 1);
	map.put('V', 5);
	map.put('X', 10);
	map.put('L', 50);
	map.put('C', 100);
	map.put('D', 500);
	map.put('M', 1000);
        int i = 0, num = 0;
	while (i < s.length()) {
	    int add = map.get(s.charAt(i));
	    if ((s.charAt(i) == 'I') || (s.charAt(i) == 'X') || (s.charAt(i) == 'C')) {
		if ((i + 1 < s.length()) && (map.get(s.charAt(i + 1)) > add)) {
		    add = -add + map.get(s.charAt(i + 1));
		    i++;
		}
	    }
	    num += add;
	    i++;
	}
	return num;
    }
    public static void main(String[] args) {
	roman2Int solution = new roman2Int();
	System.out.println(solution.romanToInt("MMMCCCXXXIII"));
	System.out.println(solution.romanToInt("MMXIV"));
    }
}