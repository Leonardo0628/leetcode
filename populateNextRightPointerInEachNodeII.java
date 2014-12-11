public class populateNextRightPointerInEachNodeII {
    // Find the node with at least one child
    private TreeLinkNode[] findNext(TreeLinkNode head) {
	TreeLinkNode p = head;
	while (p != null) {
	    if (p.left != null) {
		TreeLinkNode[] nodes = {p, p.left};
		return nodes;
	    }
	    if (p.right != null) {
		TreeLinkNode[] nodes = {p, p.right};
		return nodes;
	    }
	    p = p.next;
	}
	TreeLinkNode[] nodes = {null, null};
	return nodes;
    }
    public void connect(TreeLinkNode root) {
	TreeLinkNode head = root;
	while (head != null) {
	    TreeLinkNode[] nodes = findNext(head);
	    TreeLinkNode p = nodes[0], child = nodes[1];
	    while (p != null) {
		TreeLinkNode p2 = p;
		if ((p.left == child) && (p.right != null)) {
		    child.next = p.right;
		} else {
		    nodes = findNext(p.next);
		    p2 = nodes[0];
		    TreeLinkNode nextChild = nodes[1];
		    if (p2 != null) {
			child.next = nextChild;
		    }
		}
		child = child.next;
		p = p2;
	    }
	    nodes = findNext(head);
	    head = nodes[1];
	}
    }
    public static void main(String[] args) {
        populateNextRightPointerInEachNodeII solution = new populateNextRightPointerInEachNodeII();
    }
}