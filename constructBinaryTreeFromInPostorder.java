import java.util.*;

public class constructBinaryTreeFromInPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
	    return null;
	}
	TreeNode root = new TreeNode(postorder[postorder.length - 1]);
	int rootIdx = 0;
	for (int i = 1; i < inorder.length; i++) {
	    if (inorder[i] == root.val) {
		rootIdx = i;
	    }
	}
	int[] inorderLeft = new int[rootIdx];
	int[] postorderLeft = new int[rootIdx];
	int[] inorderRight = new int[inorder.length - rootIdx - 1];
	int[] postorderRight = new int[inorder.length - rootIdx - 1];
	for (int i = 0; i < inorder.length; i++) {
	    if (i < rootIdx) {
		inorderLeft[i] = inorder[i];
		postorderLeft[i] = postorder[i];
	    } else if (i > rootIdx) {
		inorderRight[i - rootIdx - 1] = inorder[i];
		postorderRight[i - rootIdx - 1] = postorder[i - 1];
	    }
	}
	root.left = buildTree(inorderLeft, postorderLeft);
	root.right = buildTree(inorderRight, postorderRight);	    
	return root;
    }
    public static void main(String[] args) {
	constructBinaryTreeFromInPostorder solution = new constructBinaryTreeFromInPostorder();
	int[] in = {4, 2, 5, 1, 3};
	int[] post = {4, 5, 2, 3, 1};
	TreeNode root = solution.buildTree(in, post);
	System.out.println(root);
	System.out.println(root.val);
	System.out.println(root.left.val);
	System.out.println(root.right.val);
	System.out.println(root.left.left.val);
	System.out.println(root.left.right.val);
    }
}