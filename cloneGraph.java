import java.util.*;

public class cloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	if (node == null) {
	    return null;
	}
	Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
	Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
	queue.offer(node);
	UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
	map.put(clone.label, clone);
	while (queue.size() > 0) {
	    UndirectedGraphNode head = queue.poll();
	    for (int i = 0; i < head.neighbors.size(); i++) {
		UndirectedGraphNode neighborNode = head.neighbors.get(i);
		if (!map.containsKey(neighborNode.label)) {
		    queue.offer(neighborNode);
		    UndirectedGraphNode newNode = new UndirectedGraphNode(neighborNode.label);
		    map.put(newNode.label, newNode);
		}
		map.get(head.label).neighbors.add(map.get(neighborNode.label));
	    }
	}
	return map.get(node.label);
    }
    public static void main(String[] args) {
	cloneGraph solution = new cloneGraph();
	UndirectedGraphNode node1 = new UndirectedGraphNode(0);
	UndirectedGraphNode node2 = new UndirectedGraphNode(1);
	UndirectedGraphNode node3 = new UndirectedGraphNode(2);
	UndirectedGraphNode clone1 = solution.cloneGraph(null);
	//System.out.println(clone1.label);
	//System.out.println(clone1.neighbors.size());
	node1.neighbors.add(node2);
	node1.neighbors.add(node3);
	node2.neighbors.add(node3);
	node3.neighbors.add(node3);
	UndirectedGraphNode clone2 = solution.cloneGraph(node1);
	System.out.println(clone2.label);
	System.out.println(clone2.neighbors.size());
	System.out.println(clone2.neighbors.get(0).label);
	System.out.println(clone2.neighbors.get(0).neighbors.size());
	System.out.println(clone2.neighbors.get(1).label);
	System.out.println(clone2.neighbors.get(1).neighbors.size());
    }
}