class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;

        int dp[][]=new int[n+1][amount+1];
        // there is one way to make amount 0 using 0 coins if we don't choose anything
        dp[0][0]=1;

        for(int i=1;i<=n;i++){
            for(int amt=0;amt<=amount;amt++){
                int take=0;
                if(amt>=coins[i-1]){
                    take=dp[i][amt-coins[i-1]];
                }
                int skip=dp[i-1][amt];
                // add the total number of ways
                dp[i][amt]=take+skip;
            }
        }
        return dp[n][amount];
       
    }
}