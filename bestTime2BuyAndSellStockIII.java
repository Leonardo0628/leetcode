public class bestTime2BuyAndSellStockIII {
    public int maxProfit(int[] prices) {
	if (prices.length == 0) {
	    return 0;
	}
	int localMin = prices[0];
	int[] leftMax = new int[prices.length];
	int[] rightMax = new int[prices.length];
	leftMax[0] = 0;
	for (int i = 1; i < prices.length; i++) {
	    localMin = Math.min(localMin, prices[i]);
	    leftMax[i] = Math.max(leftMax[i - 1], prices[i] - localMin);
	}
	rightMax[prices.length - 1] = 0;
	int localMax = prices[prices.length - 1];
	for (int i = prices.length - 2; i >= 0; i--) {
	    localMax = Math.max(localMax, prices[i]);
	    rightMax[i] = Math.max(rightMax[i + 1], localMax - prices[i]);
	}
	int maxP = 0;
	for (int i = 0; i < prices.length; i++) {
	    maxP = Math.max(maxP, leftMax[i] + rightMax[i]);
	}
        return maxP;
    }
    public static void main(String[] args) {
	bestTime2BuyAndSellStockIII solution = new bestTime2BuyAndSellStockIII();
	int[] prices = {56, 98, -1, 2};
	System.out.println(solution.maxProfit(prices));
    }
}