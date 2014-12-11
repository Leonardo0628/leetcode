import java.util.*;

public class binaryTreeMinDepth {
    public int minDepth(TreeNode root) {
	if (root == null) {
	    return 0;
	}
	int minLeft = minDepth(root.left), minRight = minDepth(root.right);
	if (Math.min(minLeft, minRight) == 0) {
	    return (Math.max(minLeft, minRight) + 1);
	} else {
	    return (Math.min(minLeft, minRight) + 1);
	}
    }
    public static void main(String[] args) {
	binaryTreeMinDepth solution = new binaryTreeMinDepth();
	TreeNode root = new TreeNode(1);
	TreeNode left = new TreeNode(2);
	TreeNode right = new TreeNode(5);
	TreeNode node1 = new TreeNode(3);
	TreeNode node2 = new TreeNode(4);
	System.out.println(solution.minDepth(null));
	System.out.println(solution.minDepth(root));
	left.left = node1;
	//left.right = node2;
	root.left = left;
	//root.right = right;
	System.out.println(solution.minDepth(root));
    }
}