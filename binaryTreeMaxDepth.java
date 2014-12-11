import java.util.*;

public class binaryTreeMaxDepth {
    public int maxDepth(TreeNode root) {
	if (root == null) {
	    return 0;
	}
	return (Math.max(maxDepth(root.left), maxDepth(root.right)) + 1);
    }
    public static void main(String[] args) {
	binaryTreeMaxDepth solution = new binaryTreeMaxDepth();
	TreeNode root = new TreeNode(1);
	TreeNode left = new TreeNode(2);
	TreeNode right = new TreeNode(5);
	TreeNode node1 = new TreeNode(3);
	TreeNode node2 = new TreeNode(4);
	System.out.println(solution.maxDepth(null));
	System.out.println(solution.maxDepth(root));
	left.left = node1;
	//left.right = node2;
	root.left = left;
	//root.right = right;
	System.out.println(solution.maxDepth(root));
    }
}