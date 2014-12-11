public class bestTime2BuyAndSellStock {
    public int maxProfit(int[] prices) {
	if (prices.length == 0) {
	    return 0;
	}
	int maxP = 0, localMin = prices[0];
	for (int i = 1; i < prices.length; i++) {
	    localMin = Math.min(localMin, prices[i]);
	    maxP = Math.max(maxP, prices[i] - localMin);
	}
        return maxP;
    }
    public static void main(String[] args) {
	bestTime2BuyAndSellStock solution = new bestTime2BuyAndSellStock();
	int[] prices = {56, 98, -1, 2};
	System.out.println(solution.maxProfit(prices));
    }
}