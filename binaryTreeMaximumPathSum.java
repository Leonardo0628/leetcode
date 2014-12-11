public class binaryTreeMaximumPathSum {
    private int maxPath(TreeNode root, int[] max) {
	if (root == null) {
	    return Integer.MIN_VALUE;
	}
	int leftPath = Math.max(maxPath(root.left, max), 0);
	int rightPath = Math.max(maxPath(root.right, max), 0);
	max[0] = Math.max(max[0], root.val + leftPath + rightPath);
	return (root.val + Math.max(leftPath, rightPath));
    }
    public int maxPathSum(TreeNode root) {
	int[] max = {Integer.MIN_VALUE};
	int rootPath = maxPath(root, max);
	return Math.max(max[0], rootPath);
    }
    public static void main(String[] args) {
	binaryTreeMaximumPathSum solution = new binaryTreeMaximumPathSum();
	TreeNode root = new TreeNode(1);
	TreeNode left = new TreeNode(2);
	TreeNode right = new TreeNode(3);
	root.left = left;
	root.right = right;
	System.out.println(solution.maxPathSum(root));
    }
}