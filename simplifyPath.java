import java.util.*;

public class simplifyPath {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
	Deque<String> stack = new LinkedList<String>();
	for (int i = 0; i < split.length; i++) {
	    if (split[i].equals("") || split[i].equals(".")) {
		continue;
	    }
	    if (split[i].equals("..")) {
		if (stack.size() > 0) {
		    stack.pop();
		}
	    } else {
		stack.push(split[i]);
	    }
	}
	String simplify = "";
	if (stack.size() == 0) {
	    return "/";
	}
	while (stack.size() > 0) {
	    simplify = "/" + stack.pop() + simplify;
	}
	return simplify;
    }
    public static void main(String[] args) {
	simplifyPath solution = new simplifyPath();
	System.out.println(solution.simplifyPath("/home/"));
	System.out.println(solution.simplifyPath("/a/./b/../../c/"));
	System.out.println(solution.simplifyPath("/../"));
	System.out.println(solution.simplifyPath("/home//foo/"));
    }
}