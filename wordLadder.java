import java.util.*;

public class wordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
	dict.add(end);
	Queue<String> queue = new LinkedList<String>();
	Queue<Integer> step = new LinkedList<Integer>();
	queue.offer(start);
	step.offer(1);
	while (queue.size() > 0) {
	    String head = queue.poll();
	    int count = step.poll();
	    if (head.equals(end)) {
		return count;
	    }
	    for (int i = 0; i < head.length(); i++) {
		for (char j = 'a'; j <= 'z'; j++) {
		    String replace = head.substring(0, i) + j + head.substring(i + 1, head.length());
		    if (dict.contains(replace)) {
			dict.remove(replace);
			queue.offer(replace);
			step.offer(count + 1);
		    }
		}
	    }
	}
        return 0;
    }
    public static void main(String[] args) {
	wordLadder solution = new wordLadder();
	System.out.println(solution.ladderLength("hit", "cog", new HashSet(Arrays.asList("hot","dot","dog","lot","log"))));
	System.out.println(solution.ladderLength("hit", "hit", new HashSet(Arrays.asList("hot","dot","dog","lot","log"))));
	System.out.println(solution.ladderLength("hot", "dog", new HashSet(Arrays.asList("hot","dot","dog","lot","log"))));
	System.out.println(solution.ladderLength("hit", "hit", new HashSet()));
	System.out.println(solution.ladderLength("hit", "abc", new HashSet()));
    }
}