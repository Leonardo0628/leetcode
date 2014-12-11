public class gasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, start = 0, cumsum = 0;
	for (int i = 0; i < gas.length; i++) {
	    total += gas[i] - cost[i];
	    cumsum += gas[i] - cost[i];
	    // If sum(diff[start], ..., diff[i]) < 0, then we can't start from start, start + 1, ..., i - 1, i
	    if (cumsum < 0) {
		start = i + 1;
		cumsum = 0;
	    }
	}
	if (total < 0) {
	    return -1;
	} else {
	    return start;
	}
    }
    public static void main(String[] args) {
	gasStation solution = new gasStation();
    }
}