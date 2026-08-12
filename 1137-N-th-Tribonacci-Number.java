class Solution {
    public int solve(int dp[], int n){
        if(n==0)
        return 0;

        if(n==1 || n==2)
        return 1;

        if(dp[n]!=-1)
        return dp[n];

        return dp[n]=solve(dp,n-1)+ solve(dp,n-2)+ solve(dp,n-3);
    }
    public int tribonacci(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(dp,n);
    }
}