public class balanceBinaryTree {
    public int depth(TreeNode root) {
	if (root == null) {
	    return 0;
	}
	return (Math.max(depth(root.left), depth(root.right)) + 1);
    }
    public boolean isBalanced(TreeNode root) {
	if (root == null) {
	    return true;
	}
	return (isBalanced(root.left) && isBalanced(root.right) && (Math.abs(depth(root.left)-depth(root.right))<=1));
    }
    public static void main(String[] args) {
	balanceBinaryTree solution = new balanceBinaryTree();
	TreeNode root = new TreeNode(1);
	TreeNode left = new TreeNode(2);
	TreeNode right = new TreeNode(5);
	TreeNode node1 = new TreeNode(3);
	TreeNode node2 = new TreeNode(4);
	System.out.println(solution.isBalanced(null));
	System.out.println(solution.isBalanced(root));
	left.left = node1;
	//left.right = node2;
	root.left = left;
	//root.right = right;
	System.out.println(solution.isBalanced(root));
    }
}