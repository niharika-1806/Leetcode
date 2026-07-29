class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxi=0;
        int mask=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            while((nums[i] & mask)!=0){
                mask^=nums[j];
                j++;
            }
            mask=mask|nums[i];
            maxi=Math.max(maxi,i-j+1);
        }
        return maxi;
    }
}