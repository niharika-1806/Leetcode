class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int inf=1_000_000;
        // minimum number of coins needed to make amount using first i coins
        int dp[][]=new int[n+1][amount+1];
        // we can make 0 sum using 0 coins
        dp[0][0]=0;

        // we cannot make any sum using 0 coins
        for(int sum=1;sum<=amount;sum++){
            dp[0][sum]=inf;
        }
        for(int i=1;i<=n;i++){
            for(int amt=0;amt<=amount;amt++){
                int take=inf;
                if(amt>=coins[i-1]){
                    take=1+ dp[i][amt-coins[i-1]];
                }
                int skip=dp[i-1][amt];

                dp[i][amt]=Math.min(take,skip);
            }
        }
        if(dp[n][amount]==inf)
        return -1;

        return dp[n][amount];
    }
}