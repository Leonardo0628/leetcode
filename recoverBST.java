public class recoverBST {
    private void inorder(TreeNode curr, TreeNode[] nodes) {
	// nodes[0] record the previous node visited in the inorder traversal
	// nodes[1] record the position of the first misplaced node
	// nodes[2] record the position of the second misplaced node
	if (curr != null) {
	    inorder(curr.left, nodes);
	    if (nodes[0] != null) {
		if (curr.val < nodes[0].val) {
		    if (nodes[1] == null) {
			nodes[1] = nodes[0];
			nodes[2] = curr;
		    } else {
			nodes[2] = curr;
			return;
		    }
		}
	    }
	    nodes[0] = curr;
	    inorder(curr.right, nodes);
	}
    }
    public void recoverTree(TreeNode root) {
        TreeNode[] nodes = new TreeNode[3];
	inorder(root, nodes);
	// Swap the values of two misplaced nodes
	int tmp = nodes[1].val;
	nodes[1].val = nodes[2].val;
	nodes[2].val = tmp;
    }
}