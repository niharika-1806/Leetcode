class Solution {
    public long maxProduct(int[] nums) {
        long product=0;
        int max1=-1;
        int max2=-1;
        for(int i=0;i<nums.length;i++){
            nums[i]=Math.abs(nums[i]);
            if(nums[i]>max1){
                max2=max1;
                max1=nums[i];
            }
            else if(nums[i]>max2){
                max2=nums[i];
            }
        }
        product=(long)max1*max2*100000;
        return product;

    }
}