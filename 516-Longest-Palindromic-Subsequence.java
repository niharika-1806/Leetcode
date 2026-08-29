class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        // length of longest subsequence in range of i to j
        int dp[][]=new int[n][n];

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j)
                dp[i][j]=1;

                else if(s.charAt(i)==s.charAt(j)){
                    // if we take both i and j then we will add 2 into the length and i will move forward and j will move backwards
                    dp[i][j]=2+dp[i+1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}