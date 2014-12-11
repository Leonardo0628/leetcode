public class removeNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
	// Pseudo head + Two pointers
        ListNode pseudo = new ListNode(0), p1 = pseudo, p2 = pseudo;
	pseudo.next = head;
	for (int i = 1; i <= n; i++) {
	    p2 = p2.next;
	}
	while (p2.next != null) {
	    p1 = p1.next;
	    p2 = p2.next;
	}
	p1.next = p1.next.next;
	return pseudo.next;
    }
    public static void main(String[] args) {
	removeNthNodeFromEndOfList solution = new removeNthNodeFromEndOfList();
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(4);
	ListNode node5 = new ListNode(5);
	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node5;
	ListNode out = solution.removeNthFromEnd(node1, 2);
	System.out.println(out.val);
	System.out.println(out.next.val);
	System.out.println(out.next.next.val);
	System.out.println(out.next.next.next.val);
	System.out.println(out.next.next.next.next);
    }
}