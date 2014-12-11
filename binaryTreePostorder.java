import java.util.*;

public class binaryTreePostorder {
    public List<Integer> postorderTraversal(TreeNode root) {
	List<Integer> order = new ArrayList<Integer>();
	Deque<TreeNode> stack = new LinkedList<TreeNode>();
	stack.push(root);
	while (stack.size() > 0) {
	    TreeNode curr = stack.pop();
	    if (curr != null) {
		order.add(0, curr.val);
		if (curr.left != null) {
		    stack.push(curr.left);
		}
		if (curr.right != null) {
		    stack.push(curr.right);
		}
	    }
	}
	return order;
    }
    public static void main(String[] args) {
	binaryTreePostorder solution = new binaryTreePostorder();
	TreeNode node1 = new TreeNode(1);
	TreeNode node2 = new TreeNode(2);
	TreeNode node3 = new TreeNode(3);
	TreeNode node4 = new TreeNode(4);
	TreeNode node5 = new TreeNode(5);
	TreeNode node6 = new TreeNode(6);
	TreeNode node7 = new TreeNode(7);
	node1.left = node2;
	node1.right = node3;
	node2.left = node4;
	node2.right = node5;
	node3.left = node6;
	node3.right = node7;
	System.out.println(solution.postorderTraversal(node1));
	System.out.println(solution.postorderTraversal(null));
	System.out.println(solution.postorderTraversal(node2));
    }
}