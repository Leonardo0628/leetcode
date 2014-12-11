public class countAndSay {
    public String countAndSay(int n) {
	String curr = "1";
	for (int i = 2; i <=n; i++) {
	    String newS = "";
	    int j = 1, count = 1;
	    for (j = 1; j < curr.length(); j++) {
		if (curr.charAt(j) == curr.charAt(j - 1)) {
		    count++;
		} else {
		    newS = newS + count + curr.charAt(j - 1);
		    count = 1;
		}
	    }
	    curr = newS + count + curr.charAt(j - 1);
	}
        return curr;
    }
    public static void main(String[] args) {
	countAndSay solution = new countAndSay();
	System.out.println(solution.countAndSay(1));
	System.out.println(solution.countAndSay(2));
	System.out.println(solution.countAndSay(3));
	System.out.println(solution.countAndSay(4));
	System.out.println(solution.countAndSay(5));
    }
}