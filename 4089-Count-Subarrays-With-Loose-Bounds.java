class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count=0;
        int i=0,j=0;
        while(j<nums.length){
            if(nums[j]>=minK && nums[j]<=maxK){
                count+=(j-i+1);
            }
            else{
                i=j+1;
            }
            j++;
        }
        return count;
    }
}