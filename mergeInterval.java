import java.util.*;

public class mergeInterval {
    public List<Interval> merge(List<Interval> intervals) {
	List<Interval> mergeInterval = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
	    public int compare(Interval x, Interval y) {
		return (x.start - y.start);
	    }
	});
	// Two pointers
	int p1 = 0, p2 = 0;
	while (p2 < intervals.size()) {
	    int rightEnd = intervals.get(p1).end;
	    while ((p2 < intervals.size()) && (intervals.get(p2).start <= rightEnd)) {
		rightEnd = Math.max(rightEnd, intervals.get(p2).end);
		p2++;
	    }
	    mergeInterval.add(new Interval(intervals.get(p1).start, rightEnd));
	    p1 = p2;
	    p2 = p1;
	}
	return mergeInterval;
    }
    public static void main(String[] args) {
	mergeInterval solution = new mergeInterval();
	Interval interval1 = new Interval(1, 3);
	Interval interval2 = new Interval(2, 6);
	Interval interval3 = new Interval(8, 10);
	Interval interval4 = new Interval(15, 18);
	List<Interval> list = new ArrayList<Interval>();
	list.add(interval1);
	list.add(interval2);
	list.add(interval3);
	list.add(interval4);
	System.out.println(solution.merge(list).size());
    }
}