class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int max_score=Integer.MIN_VALUE;
            int min_score=Integer.MAX_VALUE;
            for(int j=0;j<=i;j++){
                    max_score=Math.max(max_score,nums[j]);
            }
            for(int j=i;j<n;j++){
                    min_score=Math.min(min_score,nums[j]);
            }
            int stable=max_score-min_score;
            if(stable<=k)
                return i;
        }
        return -1;
    }
}