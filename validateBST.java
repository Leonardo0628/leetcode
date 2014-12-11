public class validateBST {
    public long[] validate(TreeNode root) {
	// Output: [Minimum value, Maximum value, Whether node is a BST]
	if (root == null) {
	    long[] sum = {(long)Integer.MAX_VALUE + 1, (long)Integer.MIN_VALUE - 1, 1};
	    return sum;
	}
	long[] leftSum = validate(root.left), rightSum = validate(root.right);
	if ((leftSum[1] >= root.val) || (rightSum[0] <= root.val) || (leftSum[2] + rightSum[2] < 2)) {
	    long[] sum = {0, 0, 0};
	    return sum;
	}
	long[] sum = {Math.min(root.val, leftSum[0]), Math.max(root.val, rightSum[1]), 1};
	return sum;
    }
    public boolean isValidBST(TreeNode root) {
	return (validate(root)[2] == 1);
    }
    public static void main(String[] args) {
	validateBST solution = new validateBST();
	TreeNode root = new TreeNode(1);
	TreeNode left = new TreeNode(2);
	TreeNode right = new TreeNode(3);
	TreeNode node1 = new TreeNode(1);
	System.out.println(solution.isValidBST(null));
	System.out.println(solution.isValidBST(root));
	//root.left = left;
	//root.right = right;
        //right.right = node1;
	root.right = node1;
	System.out.println(solution.isValidBST(root));
    }
}