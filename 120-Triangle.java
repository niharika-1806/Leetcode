class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        // minimum cost to reach bottom from dp[i][j]
        int dp[][]=new int[m][];

        // each row has different size
        for(int i=0;i<m;i++){
            dp[i]=new int[triangle.get(i).size()];
        }
        
        dp[0][0]=triangle.get(0).get(0);

        // filling for bottom row
        for(int i=0;i<triangle.get(m-1).size();i++){
            dp[m-1][i]=triangle.get(m-1).get(i);
        }

        // building from bottom to up
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[i][j]=triangle.get(i).get(j)+ Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];

    }
}