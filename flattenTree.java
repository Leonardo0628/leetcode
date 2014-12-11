public class flattenTree {
    public void flatten(TreeNode root) {
        if (root == null) {
	    return;
	}
	flatten(root.left);
	flatten(root.right);
	if (root.left != null) {
	    TreeNode rightTree = root.right;
	    root.right = root.left;
	    root.left = null;
	    TreeNode iter = root.right;
	    while (iter.right != null) {
		iter = iter.right;
	    }
	    iter.right = rightTree;
	}
    }
    public static void main(String[] args) {
	flattenTree solution = new flattenTree();
	TreeNode node1 = new TreeNode(1);
	TreeNode node2 = new TreeNode(2);
	TreeNode node3 = new TreeNode(5);
	TreeNode node4 = new TreeNode(3);
	TreeNode node5 = new TreeNode(4);
	TreeNode node6 = new TreeNode(6);
	node1.left = node2;
	node1.right = node3;
	node2.left = node4;
	node2.right = node5;
	node3.right = node6;
	solution.flatten(node1);
	TreeNode iter = node1;
	while (iter != null) {
	    System.out.print(iter.val + "->");
	    iter = iter.right;
	}
	System.out.println("null");
    }
}