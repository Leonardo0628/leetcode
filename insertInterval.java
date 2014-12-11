import java.util.*;

public class insertInterval {
    private boolean overlap(Interval interval1, Interval interval2) {
	return !((interval1.end < interval2.start) || (interval1.start > interval2.end));
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	List<Interval> out = new ArrayList<Interval>();
	Interval candidate = new Interval(newInterval.start, newInterval.end);
	int iter = 0;
	boolean flag = false;
	for (int i = 0; i < intervals.size(); i++) {
	    if (overlap(candidate, intervals.get(i))) {
		candidate.start = Math.min(candidate.start, intervals.get(i).start);
		candidate.end = Math.max(candidate.end, intervals.get(i).end);
		continue;
	    }
	    if (!flag && (intervals.get(i).start > candidate.end)) {
		out.add(candidate);
		flag = true;
	    }
	    out.add(intervals.get(i));
	}
	if (!flag) {
	    out.add(candidate);
	}
        return out;
    }
    public static void main(String[] args) {
	insertInterval solution = new insertInterval();
	List<Interval> list = new LinkedList<Interval>();
	list.add(new Interval(1, 2));
	list.add(new Interval(3, 5));
	list.add(new Interval(6, 7));
	list.add(new Interval(8, 10));
	list.add(new Interval(12, 16));
	System.out.println(solution.insert(list, new Interval(4, 9)).get(1).start);
	System.out.println(solution.insert(list, new Interval(4, 9)).get(1).end);
    }
}