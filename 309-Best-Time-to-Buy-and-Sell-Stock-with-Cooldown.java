class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;

        if(n==1)
        return 0;

        int neg=-1_000_000_000;

        // maximum profit on ith day after 
        int dp[][]=new int[n][3];
        // holding a stock on ith day
        dp[0][0]=-prices[0];

        // selling a stock on ith day
        dp[0][1]=neg;

        // resting on ith day (do nothing)
        dp[0][2]=0;

        for(int i=1;i<n;i++){
            // holding
            // either already holding the stock yesterday or bought today (in rest yesterday)
            dp[i][0]=Math.max(dp[i-1][0], dp[i-1][2]-prices[i]);

            // selling
            // holding yesterday and selling today
            dp[i][1]=dp[i-1][0]+prices[i];

            // rest
            // already resting yesterday or sold yesterday 
            dp[i][2]=Math.max(dp[i-1][2], dp[i-1][1]);
        }
        return Math.max(dp[n-1][1], dp[n-1][2]);
    }
}