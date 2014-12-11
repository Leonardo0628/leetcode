import java.util.*;

public class mergeKSortList {
    private ListNode merge(List<ListNode> lists, int start, int end) {
	if (start > end) { return null; }
	if (start == end) { return lists.get(start); }
	int mid = (start + end) / 2;
	ListNode list1 = merge(lists, start, mid), list2 = merge(lists, mid + 1, end);
	ListNode pseudo = new ListNode(0), p3 = pseudo, p1 = list1, p2 = list2;
	while ((p1 != null) && (p2 != null)) {
	    if (p1.val <= p2.val) {
		p3.next = p1;
		p1 = p1.next;
	    } else {
		p3.next = p2;
		p2 = p2.next;
	    }
	    p3 = p3.next;
	}
	while (p1 != null) {
	    p3.next = p1;
	    p1 = p1.next;
	    p3 = p3.next;
	}
	while (p2 != null) {
	    p3.next = p2;
	    p2 = p2.next;
	    p3 = p3.next;
	}
	return pseudo.next;
    }
    public ListNode mergeKLists(List<ListNode> lists) {
        return merge(lists, 0, lists.size() - 1);
    }
    public static void main(String[] args) {
	mergeKSortList solution = new mergeKSortList();
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	List<ListNode> list = new ArrayList<ListNode>();
	list.add(node1);
	list.add(node2);
	list.add(node3);
	ListNode head = solution.mergeKLists(list), p = head;
	while (p != null) {
	    System.out.print(p.val + "->");
	    p = p.next;
	}
	System.out.println("null");
    }
}