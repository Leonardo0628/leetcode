import java.util.*;

public class sumRoot2LeafNum {
    private int sum(TreeNode root, int currSum) {
	if (root == null) {
	    return 0;
	} else if ((root.left == null) && (root.right == null)) {
	    return (currSum * 10 + root.val);
	}
	return (sum(root.left, currSum * 10 + root.val) + sum(root.right, currSum * 10 + root.val));
    }
    public int sumNumbers(TreeNode root) {
	return sum(root, 0);
    }
    public static void main(String[] args) {
	sumRoot2LeafNum solution = new sumRoot2LeafNum();
	TreeNode root = new TreeNode(5);
	TreeNode left = new TreeNode(3);
	TreeNode right = new TreeNode(2);
	TreeNode node1 = new TreeNode(7);
	TreeNode node2 = new TreeNode(0);
	TreeNode node3 = new TreeNode(6);
	TreeNode node4 = new TreeNode(0);
	node2.left = node4;
	left.left = node1;
	left.right = node2;
	right.left = node3;
	root.left = left;
	root.right = right;
	System.out.println(solution.sumNumbers(root));
    }
}