import java.util.*;

public class symmetricTree {
    // Recursive
    private boolean compare(TreeNode node1, TreeNode node2) {
	if (node1 == null) {
	    if (node2 == null) {
		return true;
	    } else {
		return false;
	    }
	}
	if (node2 == null) {
	    return false;
	}
	return ((node1.val == node2.val) && compare(node1.left, node2.right) && compare(node1.right, node2.left));
    }
    public boolean isSymmetric2(TreeNode root) {
        return (compare(root, root));
    }
    // Iterative
    public boolean isSymmetric(TreeNode root) {
	if (root == null) {
	    return true;
	}
	Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
	Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
	queue1.offer(root.left);
	queue2.offer(root.right);
	while (queue1.size() > 0) {
	    TreeNode head1 = queue1.poll(), head2 = queue2.poll();
	    if (head1 == null) {
		if (head2 == null) {
		    continue;
		} else {
		    return false;
		}
	    }
	    if ((head2 == null) || (head1.val != head2.val)) {
		return false;
	    }
	    queue1.offer(head1.left);
	    queue1.offer(head1.right);
	    queue2.offer(head2.right);
	    queue2.offer(head2.left);
	}
	return true;
    }
    public static void main(String[] args) {
	symmetricTree solution = new symmetricTree();
	TreeNode root = new TreeNode(1);
	TreeNode left = new TreeNode(2);
	TreeNode right = new TreeNode(2);
	TreeNode node1 = new TreeNode(3);
	TreeNode node2 = new TreeNode(4);
	TreeNode node3 = new TreeNode(4);
	TreeNode node4 = new TreeNode(3);
	System.out.println(solution.isSymmetric(null));
	System.out.println(solution.isSymmetric(root));
	//left.left = node1;
	left.right = node1;
	//right.left = node3;
	right.right = node4;
	root.left = left;
	root.right = right;
	System.out.println(solution.isSymmetric(root));
    }
}