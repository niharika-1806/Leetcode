class Solution {
    public long gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public long maxPairStrength(int[] nums) {
        long ans=Long.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long g=gcd(nums[i],nums[j]);
                long strength= ((long)nums[i]*nums[j])/(g*g);  
                ans=Math.max(ans,strength);
            }
        }
        return ans;

    }
}