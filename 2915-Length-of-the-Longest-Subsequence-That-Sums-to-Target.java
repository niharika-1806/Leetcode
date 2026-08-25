class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n=nums.size();
        // maximum length of a subsequence with sum using first i elements
        int dp[][]=new int[n+1][target+1];

        // -1 means this sum is impossible
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        dp[0][0]=0;

        for(int i=1;i<=n;i++){
            int num=nums.get(i-1);
            for(int sum=0;sum<=target;sum++){
                int take=-1;
                if(sum>=num && dp[i-1][sum-num]!=-1){
                    take=dp[i-1][sum-num]+1;
                }
                int skip=dp[i-1][sum];

                dp[i][sum]=Math.max(take,skip);
            }
        }
        return dp[n][target];

    }
}