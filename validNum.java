import java.util.regex.*;

public class validNum {
    Pattern p = Pattern.compile("^[\\+\\-]?((\\d+(\\.\\d*)?)|(\\.\\d+))(e[\\+\\-]?\\d+)?$");
    // Method 1: use regular expression
    public boolean isNumber(String s) {
        return p.matcher(s.trim()).matches();
    }
    // Method 2: use finite automaton (unfinished)
    public boolean isNumber2(String s) {
        return p.matcher(s.trim()).matches();
    }
    public static void main(String[] args) {
	validNum solution = new validNum();
	System.out.println(solution.isNumber("0"));
	System.out.println(solution.isNumber(" 0.1 "));
	System.out.println(solution.isNumber("abc"));
	System.out.println(solution.isNumber("1 a"));
	System.out.println(solution.isNumber("2e10"));
    }
}