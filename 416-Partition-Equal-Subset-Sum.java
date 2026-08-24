class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;

        for(int x: nums){
            sum+=x;
        }
        if(sum%2!=0)
        return false;
        int target=sum/2;

        boolean[][]dp=new boolean[n+1][target+1];
        dp[0][0]=true;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                boolean take=false;
                if(j>=nums[i-1]){
                    take=dp[i-1][j-nums[i-1]];
                }
                boolean skip=dp[i-1][j];

                dp[i][j]=take || skip;
            }
        }
        return dp[n][target];
    }
}