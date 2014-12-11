public class reorderList {
    public void reorderList(ListNode head) {
	if ((head == null) || (head.next == null)) {
	    return;
	}
	// Use two pointers to find the midpoint of the list
        ListNode p1 = head, p2 = head.next.next;
	while (p2 != null) {
	    p1 = p1.next;
	    p2 = p2.next;
	    if (p2 != null) {
		p2 = p2.next;
	    }
	}
	ListNode mid = p1.next;
	p1.next = null;
	// Reverse the second half of the list
	p1 = mid;
	p2 = p1.next;
	p1.next = null;
	while (p2 != null) {
	    ListNode tmp = p2.next;
	    p2.next = p1;
	    p1 = p2;
	    p2 = tmp;
	}
	// Combine two lists
	ListNode p = head;
	while (p1 != null) {
	    ListNode tmp = p1.next;
	    p1.next = p.next;
	    p.next = p1;
	    p1 = tmp;
	    p = p.next.next;
	}
    }
    public static void main(String[] args) {
	reorderList solution = new reorderList();
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(4);
	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	solution.reorderList(node1);
	ListNode p = node1;
	while (p != null) {
	    System.out.print(p.val + "->");
	    p = p.next;
	}
	System.out.println("null");
    }
}