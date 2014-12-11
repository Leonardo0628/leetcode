import java.util.*;

public class pathSumII {
    void  findPath(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> list) {
        if (root == null) {
	    return;
	} else {
	    if ((root.left == null) && (root.right == null)) {
		if (root.val == sum) {
		    List<Integer> copy = new LinkedList<Integer>();
		    copy.addAll(curr);
		    copy.add(root.val);
		    list.add(copy);
		} else {
		    return;
		}
	    } else {
		curr.add(root.val);
		findPath(root.left, sum - root.val, curr, list);
		findPath(root.right, sum - root.val, curr, list);
		curr.remove(curr.size() - 1);
	    }
	}
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	List<List<Integer>> list = new LinkedList<List<Integer>>();
	List<Integer> curr = new LinkedList<Integer>();
	findPath(root, sum, curr, list);
	return list;
    }
    public static void main(String[] args) {
	pathSumII solution = new pathSumII();
	TreeNode root = new TreeNode(5);
	TreeNode left = new TreeNode(4);
	TreeNode right = new TreeNode(8);
	TreeNode node1 = new TreeNode(11);
	TreeNode node2 = new TreeNode(13);
	TreeNode node3 = new TreeNode(4);
	TreeNode node4 = new TreeNode(7);
	TreeNode node5 = new TreeNode(2);
	TreeNode node6 = new TreeNode(5);
	TreeNode node7 = new TreeNode(1);
	root.left = left;
	root.right = right;
	left.left = node1;
	right.left = node2;
	right.right = node3;
	node1.left = node4;
	node1.right = node5;
	node3.left = node6;
	node3.right = node7;
	System.out.println(solution.pathSum(root, 22));
	System.out.println(solution.pathSum(root, 20));
    }
}