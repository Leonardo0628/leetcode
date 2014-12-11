import java.util.*;

public class constructBinaryTreeFromPreInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
	    return null;
	}
	TreeNode root = new TreeNode(preorder[0]);
	int rootIdx = 0;
	for (int i = 1; i < inorder.length; i++) {
	    if (inorder[i] == preorder[0]) {
		rootIdx = i;
	    }
	}
	int[] preorderLeft = new int[rootIdx];
	int[] inorderLeft = new int[rootIdx];
	int[] preorderRight = new int[inorder.length - rootIdx - 1];
	int[] inorderRight = new int[inorder.length - rootIdx - 1];
	for (int i = 0; i < inorder.length; i++) {
	    if (i < rootIdx) {
		preorderLeft[i] = preorder[i + 1];
		inorderLeft[i] = inorder[i];
	    } else if (i > rootIdx) {
		preorderRight[i - rootIdx - 1] = preorder[i];
		inorderRight[i - rootIdx - 1] = inorder[i];
	    }
	}
	root.left = buildTree(preorderLeft, inorderLeft);
	root.right = buildTree(preorderRight, inorderRight);	    
	return root;
    }
    public static void main(String[] args) {
	constructBinaryTreeFromPreInorder solution = new constructBinaryTreeFromPreInorder();
	int[] pre = {1, 2, 3};
	int[] in = {2, 1, 3};
	TreeNode root = solution.buildTree(pre, in);
	System.out.println(root);
	System.out.println(root.val);
	System.out.println(root.left.val);
	System.out.println(root.right.val);
	System.out.println(root.left.left.val);
	System.out.println(root.left.right.val);
    }
}