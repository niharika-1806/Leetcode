class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        // minimum sum from (i,j) till down
        int dp[][]=new int[m][n];
        
        // filling the bottom row
        for(int i=0;i<n;i++){
            dp[m-1][i]=matrix[m-1][i];
        }

        for(int i=m-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==0)
                dp[i][j]=Math.min(dp[i+1][j], Math.min(dp[i+1][j],dp[i+1][j+1])) + matrix[i][j];
                else if(j==n-1)
                dp[i][j]=Math.min(dp[i+1][j-1], Math.min(dp[i+1][j],dp[i+1][j])) + matrix[i][j];
                else
                dp[i][j]=Math.min(dp[i+1][j-1], Math.min(dp[i+1][j],dp[i+1][j+1])) + matrix[i][j];
            }
        }
        int ans=dp[0][0];
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dp[0][i]);
        }
        return ans;

    }
}