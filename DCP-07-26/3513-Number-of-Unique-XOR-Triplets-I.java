class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n<=2)
        return n;
        int ans=0;
        for(int num: nums){
            ans= ans | num;
        }
        return ans+1;
        
    }
}