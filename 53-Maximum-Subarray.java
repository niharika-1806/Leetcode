class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];

        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            // either start a new subarray or extend the previous one
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
        }
        int ans=dp[0];
        for(int d: dp){
            ans=Math.max(ans,d);
        }
        return ans;
    }
}