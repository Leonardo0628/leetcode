public class pathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
	    return false;
	}
	if ((root.left == null) && (root.right == null)) {
	    return (root.val == sum);
	}
	return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    }
    public static void main(String[] args) {
	pathSum solution = new pathSum();
	TreeNode root = new TreeNode(5);
	TreeNode left = new TreeNode(4);
	TreeNode right = new TreeNode(8);
	TreeNode node1 = new TreeNode(11);
	TreeNode node2 = new TreeNode(13);
	TreeNode node3 = new TreeNode(4);
	TreeNode node4 = new TreeNode(7);
	TreeNode node5 = new TreeNode(2);
	TreeNode node6 = new TreeNode(1);
	root.left = left;
	root.right = right;
	left.left = node1;
	right.left = node2;
	right.right = node3;
	node1.left = node4;
	node1.right = node5;
	node3.right = node6;
	System.out.println(solution.hasPathSum(root, 22));
	System.out.println(solution.hasPathSum(root, 20));
    }
}