public class bestTime2BuyAndSellStockII {
    public int maxProfit(int[] prices) {
	int maxP = 0;
	for (int i = 1; i < prices.length; i++) {
	    maxP += Math.max(0, prices[i] - prices[i - 1]);
	}
	return maxP;
    }
    public static void main(String[] args) {
	bestTime2BuyAndSellStockII solution = new bestTime2BuyAndSellStockII();
	int[] prices = {56, -98, -199, -299};
	System.out.println(solution.maxProfit(prices));
    }
}