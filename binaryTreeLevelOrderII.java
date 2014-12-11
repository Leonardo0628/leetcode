import java.util.*;

public class binaryTreeLevelOrderII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
	List<List<Integer>> list = new LinkedList<List<Integer>>();
	if (root == null) {
	    return list;
	}
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	Queue<Integer> depth = new LinkedList<Integer>();
	queue.offer(root);
	depth.offer(1);
	while (queue.size() > 0) {
	    int currDepth = depth.peek();
	    List<Integer> row = new LinkedList<Integer>();
	    while ((depth.size() > 0) && (depth.peek() == currDepth)) {
		depth.poll();
		TreeNode head = queue.poll();
		row.add(head.val);
		if (head.left != null) {
		    queue.offer(head.left);
		    depth.offer(currDepth + 1);
		}
		if (head.right != null) {
		    queue.offer(head.right);
		    depth.offer(currDepth + 1);
		}
	    }
	    list.add(0, row);
	}
	return list;
    }
    public static void main(String[] args) {
	binaryTreeLevelOrderII solution = new binaryTreeLevelOrderII();
	TreeNode root = new TreeNode(3);
	TreeNode left = new TreeNode(9);
	TreeNode right = new TreeNode(20);
	TreeNode node1 = new TreeNode(15);
	TreeNode node2 = new TreeNode(7);
	TreeNode node3 = new TreeNode(1);
	TreeNode node4 = new TreeNode(2);
	System.out.println(solution.levelOrderBottom(null));
	System.out.println(solution.levelOrderBottom(root));
	right.left = node1;
	right.right = node2;
	root.left = left;
	root.right = right;
	System.out.println(solution.levelOrderBottom(root));
	node1.right = node3;
	node2.left = node4;
	System.out.println(solution.levelOrderBottom(root));
    }
}