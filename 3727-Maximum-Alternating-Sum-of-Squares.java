class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        int len=n/2;

        long largesum=0;
        long smallsum=0;
        for(int i=0;i<len;i++){
            smallsum+=nums[i];
        }
        for(int i=len;i<n;i++){
            largesum+=nums[i];
        }
        return largesum-smallsum;

    }
}