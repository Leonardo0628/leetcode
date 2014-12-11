public class removeDuplicateFromSortListII {
    public ListNode deleteDuplicates(ListNode head) {
	if (head == null) {
	    return head;
	}
	ListNode pseudo = new ListNode(head.val - 1);
	pseudo.next = head;
	head = pseudo;
	ListNode p1 = pseudo, p2 = p1.next.next;
	while (p2 != null) {
	    int count = 1;
	    while ((p2 != null) && (p1.next.val == p2.val)) {
		p2 = p2.next;
		count++;
	    }
	    if (count > 1) {
		p1.next = p2;
	    } else {
		p1 = p1.next;
	    }
	    if (p2 != null) {
		p2 = p2.next;
	    }
	}
	return pseudo.next;
    }
    public static void main(String[] args) {
	removeDuplicateFromSortListII solution = new removeDuplicateFromSortListII();
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(1);
	ListNode node3 = new ListNode(1);
	ListNode node4 = new ListNode(3);
	ListNode node5 = new ListNode(4);
	ListNode node6 = new ListNode(4);
	ListNode node7 = new ListNode(5);
	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node5;
	node5.next = node6;
	node6.next = node7;
	ListNode newList = solution.deleteDuplicates(node1);
	while (newList != null) {
	    System.out.println(newList.val);
	    newList = newList.next;
	}
    }
}