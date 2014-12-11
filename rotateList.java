public class rotateList {
    public ListNode rotateRight(ListNode head, int n) {
	// Count length
	ListNode p1 = head;
	int len = 0;
	while (p1 != null) {
	    len++;
	    p1 = p1.next;
	}
	if (len == 0) {
	    return head;
	}
	int nmod = n % len;
	p1 = head;
	ListNode p2 = head;
	for (int i = 1; i <= nmod; i++) {
	    p2 = p2.next;
	}
	// Two pointers
	while (p2.next != null) {
	    p1 = p1.next;
	    p2 = p2.next;
	}
	p2.next = head;
	head = p1.next;
	p1.next = null;
	return head;
    }
    public static void main(String[] args) {
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(4);
	ListNode node5 = new ListNode(5);
	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node5;
	rotateList solution = new rotateList();
	ListNode head = solution.rotateRight(node1, 5);
	while (head != null) {
	    System.out.print(head.val + "->");
	    head = head.next;
	}
	System.out.println("NULL");
    }
}