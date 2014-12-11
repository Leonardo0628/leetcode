public class findPeakElem {
    // Time complexity: O(log(n))
    public int findPeakElement(int[] num) {
        int start = 0, end = num.length - 1;
	while (start < end) {
	    int mid = (start + end) / 2;
	    if (num[mid] < num[mid + 1]) {
		start = mid + 1;
	    } else {
		if ((mid == 0) || (num[mid] > num[mid - 1])) {
		    return mid;
		} else {
		    end = mid - 1;
		}
	    }
	}
	return start;
    }
    // Time complexity: O(n)
    public int findPeakElement2(int[] num) {
	if ((num.length == 1) || (num[0] > num[1])) {
	    return 0;
	}
	for (int i = 1; i <= num.length - 2; i++) {
	    if ((num[i] > num[i - 1]) && (num[i] > num[i + 1])) {
		return i;
	    }
	}
	return (num.length - 1);
    }
    public static void main(String[] args) {
	findPeakElem solution = new findPeakElem();
	int[] num = {1, 2, 3, 1};
	System.out.println(solution.findPeakElement(num));
    }
}