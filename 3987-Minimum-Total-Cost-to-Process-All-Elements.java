class Solution {
    public int minimumCost(int[] nums, int k) {
        long MOD= 1_000_000_007L;
        long left=k;
        long oper=0;
        for(int i=0;i<nums.length;i++){
            if(left<nums[i]){
                long need= nums[i]-left;
                long operneed= (need+k-1)/k;
                oper+=operneed;
                left+=operneed*k;
            }
            left-=nums[i];
        }
        long a=oper;
        long b=oper+1;

        if(a%2==0){
            a/=2;
        }
        else
        b/=2;

        long totalcost=((a%MOD)*(b%MOD)) %MOD;
        return (int)(totalcost);
    }
}