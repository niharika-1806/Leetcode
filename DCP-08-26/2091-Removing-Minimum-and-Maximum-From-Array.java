class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        int maxidx=0,minidx=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
                minidx=i;
            }
            if(nums[i]>max){
                max=nums[i];
                maxidx=i;
            }
        }

        int case1= Math.max(minidx,maxidx)+1;
        int case2= n - Math.min(minidx,maxidx);
        int case3= Math.min(minidx,maxidx) + 1 + (n- Math.max(maxidx,minidx));

        return Math.min(case1,Math.min(case2,case3));

    }
}