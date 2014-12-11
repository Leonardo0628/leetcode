import java.util.*;

public class treeNext {
    public void connect(TreeLinkNode root) {
	if (root == null) {
	    return;
	}
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
	Queue<Integer> depth = new LinkedList<Integer>();
	queue.offer(root);
	depth.offer(1);
	int step = 1;
	while (queue.size() > 0) {
	    while ((queue.size() > 0) && (depth.peek() == step)) {
		TreeLinkNode head = queue.poll();
		depth.poll();
		if (head.left != null) {
		    queue.offer(head.left);
		    depth.offer(step + 1);
		}
		if (head.right != null) {
		    queue.offer(head.right);
		    depth.offer(step + 1);
		}
		if ((queue.size() > 0) && (depth.peek() == step)) {
		    head.next = queue.peek();
		}
	    }
	    step++;
	}
    }
    public static void main(String[] args) {
	treeNext solution = new treeNext();
	TreeLinkNode root = new TreeLinkNode(1);
	TreeLinkNode node1 = new TreeLinkNode(2);
	TreeLinkNode node2 = new TreeLinkNode(3);
	TreeLinkNode node3 = new TreeLinkNode(4);
	TreeLinkNode node4 = new TreeLinkNode(5);
	TreeLinkNode node5 = new TreeLinkNode(6);
	TreeLinkNode node6 = new TreeLinkNode(7);
	root.left = node1;
	root.right = node2;
	node1.left = node3;
	node1.right = node4;
	node2.left = node5;
	node2.right = node6;
	solution.connect(null);
	solution.connect(root);
	solution.connect(root);
	solution.connect(root);
	System.out.println(root.next);
	System.out.println(root.left.next.val);
	System.out.println(root.right.next);
	System.out.println(root.left.left.next.val);
	System.out.println(root.left.right.next.val);
    }
}