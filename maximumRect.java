import java.util.*;

public class maximumRect {
    private int largestRectangleArea(int[] height) {
	int maxArea = 0;
	int[] h = new int[height.length + 1];
	for (int i = 0; i < height.length; i++) {
	    h[i] = height[i];
	}
	h[height.length] = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
	for (int i = 0; i < h.length; i++) {
	    if ((stack.size() > 0) && (h[stack.peek()] > h[i])) {
		int idx = 0;
		while ((stack.size() > 0) && (h[stack.peek()] > h[i])) {
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
    public int maximalRectangle(char[][] matrix) {
	if (matrix.length == 0) {
	    return 0;
	}
	int[] height = new int[matrix[0].length];
	for (int i = 0; i < matrix[0].length; i++) {
	    height[i] = (matrix[0][i] - '0');
	}
	int max = largestRectangleArea(height);
	for (int i = 1; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[i].length; j++) {
		if (matrix[i][j] == '0') {
		    height[j] = 0;
		} else {
		    height[j]++;
		}
	    }
	    max = Math.max(max, largestRectangleArea(height));
	}
	return max;
    }
    public static void main(String[] args) {
	maximumRect solution = new maximumRect();
	char[][] matrix = {{'0','1','1','0','0','0'},
			   {'0','1','1','1','0','0'}};
	System.out.println(solution.maximalRectangle(matrix));
    }
}