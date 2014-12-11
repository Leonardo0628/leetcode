public class containerWithMostWater {
    public int maxArea(int[] height) {
	int p1 = 0, p2 = height.length - 1;
	int max = Math.min(height[p1], height[p2]) * (p2 - p1);
	// Two pointers
	while (p1 < p2) {
	    while ((p1 < p2) && (height[p1] <= height[p2])) {
		p1++;
		max = Math.max(max, Math.min(height[p1], height[p2]) * (p2 - p1));
	    }
	    while ((p1 < p2) && (height[p1] >= height[p2])) {
		p2--;
		max = Math.max(max, Math.min(height[p1], height[p2]) * (p2 - p1));
	    }
	}
	return max;
    }
    public static void main(String[] args) {
	containerWithMostWater solution = new containerWithMostWater();
	int[] height = {1, 3, 2, 4};
	System.out.println(solution.maxArea(height));
    }
}