public class insertSort {
    public ListNode insertionSortList(ListNode head) {
	ListNode sort = new ListNode(0);
	ListNode p = head;
	while (p != null) {
	    ListNode q = sort;
	    while ((q.next != null) && (q.next.val < p.val)) {
		q = q.next;
	    }
	    ListNode pNext = p.next;
	    p.next = q.next;
	    q.next = p;
	    p = pNext;
	    
	}
	return sort.next;
    }
    public static void main(String[] args) {
	insertSort solution = new insertSort();
	ListNode node1 = new ListNode(3);
	ListNode node2 = new ListNode(1);
	ListNode node3 = new ListNode(2);
	node1.next = node2;
	node2.next = node3;
	ListNode head = solution.insertionSortList(node1);
	while (head != null) {
	    System.out.print(head.val + "->");
	    head = head.next;
	}
	System.out.println("null");
    }
}