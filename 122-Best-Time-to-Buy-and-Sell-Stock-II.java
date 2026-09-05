class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        // dp[i][0] -> maximum profit after day i when not holding a stock.
        // dp[i][1] -> maximum profit after day i when holding a stock
        int dp[][]=new int[n][2];

        dp[0][0]=0;
        // we're holding a stock on day 0 and if we decide to buy it , we spend prices[0], means we're in negative profit now
        dp[0][1]=-prices[0];

        for(int i=1;i<n;i++){
            // Not holding
            // maximum (do nothing, sell today)
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);

            // Holding
            // maximum (do nothing, bought today)
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]- prices[i]);
        }
        // final answer is not holding state because maximum profit is realised after selling
        return dp[n-1][0];

    }
}