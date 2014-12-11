public class sortList {
    public ListNode sortList(ListNode head) {
	if ((head == null) || (head.next == null)) {
	    return head;
	}
	// Two pointers to find the mid point
	ListNode p1 = head, p2 = head.next.next;
	while (p2 != null) {
	    p1 = p1.next;
	    p2 = p2.next;
	    if (p2 != null) {
		p2 = p2.next;
	    }
	}
	ListNode right = sortList(p1.next);
	p1.next = null;
	// Pseudo head nodes
	ListNode pseudo = new ListNode(0), left = pseudo;
	pseudo.next = sortList(head);
	while (right != null) {
	    while ((left.next != null) && (left.next.val < right.val)) {
		left = left.next;
	    }
	    ListNode tmpLeft = left.next, tmpRight = right.next;
	    left.next = right;
	    right.next = tmpLeft;
	    right = tmpRight;
	    left = left.next;
	}
	return pseudo.next;
    }
    public static void main(String[] args) {
	sortList solution = new sortList();
	ListNode node1 = new ListNode(3);
	ListNode node2 = new ListNode(1);
	ListNode node3 = new ListNode(4);
	ListNode node4 = new ListNode(5);
	ListNode node5 = new ListNode(2);
	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node5;
	ListNode head = solution.sortList(node1), p = head;
	while (p != null) {
	    System.out.print(p.val + "->");
	    p = p.next;
	}
	System.out.println("null");
    }
}