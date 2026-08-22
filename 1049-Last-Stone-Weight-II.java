class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int sum=0;
        for(int s: stones)
        sum+=s;

        int target=sum/2;
        int dp[][]=new int[n][target+1];
        // we can't make 0 sum by selecting i elements
        for(int i=0;i<=target;i++){
            if(stones[0]<=i)
            dp[0][i]=stones[0];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int pick=0;
                if(stones[i]<=j){
                    pick=stones[i]+ dp[i-1][j- stones[i]];
                }
                int notpick=dp[i-1][j];
                dp[i][j]=Math.max(pick,notpick);
            }
        }

        return sum - 2* dp[n-1][target];

    }
}