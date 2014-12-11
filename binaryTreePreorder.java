import java.util.*;

public class binaryTreePreorder {
    public List<Integer> preorderTraversal(TreeNode root) {
	List<Integer> order = new ArrayList<Integer>();
	Deque<TreeNode> stack = new LinkedList<TreeNode>();
	stack.push(root);
	while (stack.size() > 0) {
	    TreeNode curr = stack.pop();
	    while (curr != null) {
		order.add(curr.val);
		stack.push(curr.right);
		curr = curr.left;
	    }
	}
	return order;
    }
    public static void main(String[] args) {
	binaryTreePreorder solution = new binaryTreePreorder();
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
	System.out.println(solution.preorderTraversal(node1));
	System.out.println(solution.preorderTraversal(null));
	System.out.println(solution.preorderTraversal(node2));
    }
}