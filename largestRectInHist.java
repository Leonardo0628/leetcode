import java.util.*;

public class largestRectInHist {
    public int largestRectangleArea(int[] height) {
	int maxArea = 0;
	int[] h = new int[height.length + 1];
	for (int i = 0; i < height.length; i++) {
	    h[i] = height[i];
	}
	h[height.length] = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
	for (int i = 0; i < h.length; i++) {
	    if ((stack.size() > 0) && (h[i] < h[stack.peek()])) {
		int idx = 0;
		while ((stack.size() > 0) && (h[i] < h[stack.peek()])) {
		    idx = stack.pop();
		    if (stack.size() > 0) {
			maxArea = Math.max(maxArea, h[idx] * (i - stack.peek() - 1));
		    } else {
			maxArea = Math.max(maxArea, h[idx] * i);
		    }
		}
	    }
	    stack.push(i);
	}
	return maxArea;
    }
    public static void main(String[] args) {
	largestRectInHist solution = new largestRectInHist();
	int[] height = {2,1,5,6,2,3};
	System.out.println(solution.largestRectangleArea(height));
    }
}