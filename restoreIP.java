import java.util.*;

public class restoreIP {
    private void dfs(String s, int digit, List<String> list, String ip) {
	if (digit == 5) {
	    if (s.length() == 0) {
		list.add(ip.substring(0, ip.length() - 1));
	    }
	} else {
	    for (int i = 0; i <= Math.min(2, s.length() - 1); i++) {
		// Strings such as "010" are invalid
		if ((i > 0) && (s.charAt(0) == '0')) {
		    break;
		}
		Integer num = new Integer(s.substring(0, i + 1));
		if (num <= 255) {
		    dfs(s.substring(i + 1, s.length()), digit + 1, list, ip + num + ".");
		}
	    }
	}
    }
    public List<String> restoreIpAddresses(String s) {
	List<String> list = new ArrayList<String>();
        dfs(s, 1, list, "");
	return list;
    }
    public static void main(String[] args) {
	restoreIP solution = new restoreIP();
	System.out.println(solution.restoreIpAddresses("25525511135"));
	System.out.println(solution.restoreIpAddresses("010010"));
    }
}