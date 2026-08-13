class Solution {
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int x:nums){
            max=Math.max(max,x);
        }
        int total[]=new int[max+1];

        // total points we get if we choose n
        for(int x:nums){
            total[x]+=x;
        }
        // maximum points we can earn
        int dp[]=new int[max+1];
        dp[0]=0;

        if(max==0)
        return total[0];

        dp[1]=Math.max(total[0],total[1]);
        for(int i=2;i<=max;i++){
            dp[i]=Math.max(dp[i-2]+total[i], dp[i-1]);
        }
        
        return dp[max];

    }
}