import java.util.*;

public class uniqueBSTII {
    List<TreeNode> buildBST(int start, int end) {
	List<TreeNode> list = new LinkedList<TreeNode>();
	if (start > end) {
	    list.add(null);
	}
	for (int i = start; i <= end; i++) {
	    List<TreeNode> listLeft = buildBST(start, i - 1);
	    List<TreeNode> listRight = buildBST(i + 1, end);
	    for (int j = 0; j < listLeft.size(); j++) {
		for (int k = 0; k < listRight.size(); k++) {
		    TreeNode root = new TreeNode(i);
		    root.left = listLeft.get(j);
		    root.right = listRight.get(k);
		    list.add(root);
		}
	    }
	}
	return list;
    }
    public List<TreeNode> generateTrees(int n) {
        return buildBST(1, n);
    }
    public static void main(String[] args) {
	uniqueBSTII solution = new uniqueBSTII();
	System.out.println(solution.generateTrees(3).size());
	System.out.println(solution.generateTrees(0));
	System.out.println(solution.generateTrees(1).size());
	System.out.println(solution.generateTrees(2).size());
	System.out.println(solution.generateTrees(4).size());
    }
}