public class merge2SortList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pseudo = new ListNode(0), curr = pseudo;
	while ((l1 != null) && (l2 != null)) {
	    if (l1.val <= l2.val) {
		curr.next = l1;
		l1 = l1.next;
	    } else {
		curr.next = l2;
		l2 = l2.next;
	    }
	    curr = curr.next;
	}
	while (l1 != null) {
	    curr.next = l1;
	    l1 = l1.next;
	    curr = curr.next;
	}
	while (l2 != null) {
	    curr.next = l2;
	    l2 = l2.next;
	    curr = curr.next;
	}
	return pseudo.next;
    }
    public static void main(String[] args) {
	merge2SortList solution = new merge2SortList();
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(4);
	ListNode node5 = new ListNode(5);
	node1.next = node3;
	node3.next = node5;
	node2.next = node4;
	ListNode head = solution.mergeTwoLists(node1, node2), curr = head.next;
	System.out.print(head.val);
	while (curr != null) {
	    System.out.print("->"+curr.val);
	    curr = curr.next;
	}
	System.out.println();
    }
}