public class sameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
	if (p == null) {
	    if (q == null) {
		return true;
	    } else {
		return false;
	    }
	}
	if (q == null) {
	    return false;
	}
        return ((p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
    public static void main(String[] args) {
	same_tree solution = new same_tree();
	TreeNode root1 = new TreeNode(1);
	TreeNode left1 = new TreeNode(2);
	TreeNode right1 = new TreeNode(3);
	TreeNode root2 = new TreeNode(1);
	TreeNode left2 = new TreeNode(2);
	TreeNode right2 = new TreeNode(3);
	System.out.println(solution.isSameTree(null, null));
	System.out.println(solution.isSameTree(root1, root2));
	System.out.println(solution.isSameTree(root1, null));
	root1.left = left1;
	root1.right = right1;
	root2.left = left2;
	root2.right = right2;
	System.out.println(solution.isSameTree(root1, root2));
	root2.right = right1;
	System.out.println(solution.isSameTree(root1, root2));
	root2.right = left1;
	System.out.println(solution.isSameTree(root1, root2));
    }
}