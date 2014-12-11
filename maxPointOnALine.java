import java.util.*;

public class maxPointOnALine {
    private void mapPut(Map<String, Integer> map, String str) {
	if (!map.containsKey(str)) {
	    map.put(str, 1);
	} else {
	    map.put(str, map.get(str) + 1);
	}
    }
    private int gcd(int a, int b) {
	if (b == 0) {
	    return a;
	} else {
	    return gcd(b, a % b);
	}
    }
    public int maxPoints(Point[] points) {
	int max = 0;
	for (int i = 0; i < points.length; i++) {
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    for (int j = 0; j < points.length; j++) {
		int dy = points[i].y - points[j].y;
		int dx = points[i].x - points[j].x;
		if ((dx == 0) && (dy == 0)) {
		    mapPut(map, "0/0");
		} else if (dx == 0) {
		    if (dy > 0) {
			mapPut(map, "1/0");
		    } else {
			mapPut(map, "-1/0");
		    }
		} else {
		    boolean sign = ((dy * 1.0 / dx) >= 0);
		    int gcd = gcd(Math.abs(dx), Math.abs(dy));
		    if (sign) {
			mapPut(map, Math.abs(dy) / gcd + "/" + Math.abs(dx) / gcd);
		    } else {
			mapPut(map, "-" + Math.abs(dy) / gcd + "/" + Math.abs(dx) / gcd);
		    }
		}
	    }
	    int duplicate = map.get("0/0");
	    map.remove("0/0");
	    max = Math.max(max, duplicate);
	    Iterator<Integer> iter = map.values().iterator();
	    while (iter.hasNext()) {
		max = Math.max(max, iter.next() + duplicate);
	    }
	}
	return max;
    }
    public static void main(String[] args) {
	maxPointOnALine solution = new maxPointOnALine();
	Point[] points = {new Point(0, 0), new Point(0, 2),
			  new Point(2, 0), new Point(2, 2),
			  new Point(0, 3), new Point(0, 0)};
	System.out.println(solution.maxPoints(points));
    }
}