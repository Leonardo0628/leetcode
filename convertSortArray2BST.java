public class convertSortArray2BST {
    TreeNode buildBST(int[] num, int start, int end) {
	if (start > end) {
	    return null;
	}
	int mid = (start + end) / 2;
	TreeNode root = new TreeNode(num[mid]);
	root.left = buildBST(num, start, mid - 1);
	root.right = buildBST(num, mid + 1, end);
	return root;
    }
    public TreeNode sortedArrayToBST(int[] num) {
        return buildBST(num, 0, num.length - 1);
    }
    public static void main(String[] args) {
	convertSortArray2BST solution = new convertSortArray2BST();
	int[] list = {1, 2, 3, 4, 5};
	TreeNode root = solution.sortedArrayToBST(list);
	System.out.println(root.val);
	System.out.println(root.left.val);
	System.out.println(root.right.val);
	System.out.println(root.left.right.val);
	System.out.println(root.right.right.val);
    }
}