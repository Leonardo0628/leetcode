public class convertSortList2BST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
	    return null;
	} else if (head.next == null) {
	    return (new TreeNode(head.val));
	}
	ListNode p1 = head, p2 = head.next.next;
	while ((p2 != null) && (p2.next != null)) {
	    p1 = p1.next;
	    p2 = p2.next.next;
	}
	TreeNode root = new TreeNode(p1.next.val);
	TreeNode right = sortedListToBST(p1.next.next);
	p1.next = null;
	TreeNode left = sortedListToBST(head);
	root.left = left;
	root.right = right;
	return root;
    }
    public static void main(String[] args) {
	convertSortList2BST solution = new convertSortList2BST();
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(4);
	ListNode node5 = new ListNode(5);
	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node5;
	TreeNode root = solution.sortedListToBST(node1);
	System.out.println(root.val);
	System.out.println(root.left.val);
	System.out.println(root.right.val);
	System.out.println(root.left.left.val);
	System.out.println(root.right.left.val);
    }
}