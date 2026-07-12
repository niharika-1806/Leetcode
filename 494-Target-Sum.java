class Solution {
    int ways=0;
    public void solve(int i,int sum, int[]nums,int target){
        if(i==nums.length){
            if(sum==target){
                ways++;
            }
            return;
        }
        solve(i+1,sum+nums[i],nums,target);
        solve(i+1,sum-nums[i],nums,target);
    }

    public int findTargetSumWays(int[] nums, int target) {
        solve(0,0,nums,target);
        return ways;
    }
}