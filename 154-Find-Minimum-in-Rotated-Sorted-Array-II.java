class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            // mnimum could be at left or at mid
            if(nums[mid]<nums[high]){
                high=mid;
            }
            // minimum will be in the right
            else if(nums[mid]>nums[high]){
                low=mid+1;
            }
            // cannot determine, so remove a duplicate from right
            else{
                high--;
            }
        }
        return nums[low];
    }
}