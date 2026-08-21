class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;

        int sum=0;
        for(int num: nums){
            sum+=num;
        }
        int target=sum/2;

        if(sum%2!=0)
        return false;

        // can we make exactly sum equal to target using first i numbers
        boolean dp[][]=new boolean[n+1][target+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            for(int s=0;s<=target;s++){
                // if the current number is less than the required sum then move ahead
                if(nums[i-1]<=s){
                    dp[i][s]= dp[i-1][s] || dp[i-1][s-nums[i-1]];
                }
                // otherwise fill the previous answer
                else{
                    dp[i][s]=dp[i-1][s];
                }
            }
            
        }
        return dp[n][target];
    }
}