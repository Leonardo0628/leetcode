public class populateNextRightPointerInEachNode {
    public void connect(TreeLinkNode root) {
	if (root == null) {
	    return;
	}
	TreeLinkNode head = root;
	while (head.left != null) {
	    TreeLinkNode p = head;
	    while (p != null) {
		p.left.next = p.right;
		if (p.next != null) {
		    p.right.next = p.next.left;
		}
		p = p.next;
	    }
	    head = head.left;
	}
    }
    public static void main(String[] args) {
        populateNextRightPointerInEachNode solution = new populateNextRightPointerInEachNode();
    }
}